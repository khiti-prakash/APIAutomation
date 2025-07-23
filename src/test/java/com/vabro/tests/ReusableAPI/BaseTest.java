package com.vabro.tests.ReusableAPI;

import com.vabro.api.Login.LoginResponse;
import com.vabro.api.LoginService;
import com.vabro.api.RefreshToken.RefreshTokenResponse;
import com.vabro.api.RefreshTokenService;
import com.vabro.data.VabroLoginTestData;
import com.vabro.utils.JwtUtils;
import config.AppConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Map;

public class BaseTest {
    protected String environment;

    @BeforeClass(alwaysRun = true)
    @Parameters({"env"})
    public void setup(@Optional("dev") String env) {
        this.environment = env;
        System.out.println("Running in environment: " + env);

        if (!env.equalsIgnoreCase("dev") && !env.equalsIgnoreCase("prod")) {
            System.out.println("Unsupported environment. Skipping token setup.");
            return;
        }

        // Load correct config file
        AppConfig.load(env); // Ensure this is added

        String token = AppConfig.getBearerToken();
        String refreshToken = AppConfig.getRefreshToken();

        boolean tokenExpired = token == null || token.isEmpty() || JwtUtils.isTokenExpired(token);
        boolean userChanged = false;

        if (token != null && !token.isEmpty()) {
            String userIdFromToken = JwtUtils.getUserIdFromToken(token);
            userChanged = !userIdFromToken.equalsIgnoreCase(AppConfig.getEmail());
        }

        if (tokenExpired || userChanged) {
            System.out.println("Token expired or user changed. Re-authenticating...");

            // Try to refresh first
            if (!tokenExpired && refreshToken != null && !refreshToken.isEmpty()) {
                RefreshTokenService refreshService = new RefreshTokenService();
                RefreshTokenResponse response = refreshService.refreshToken(refreshToken);

                if (response != null && response.getToken() != null && !response.getToken().isEmpty()) {
                    AppConfig.updateBearerToken(response.getToken());
                    AppConfig.updateRefreshToken(response.getRefreshToken());
                    System.out.println("Token refreshed successfully.");
                    return;
                } else {
                    System.out.println("Token refresh failed. Falling back to full login.");
                }
            }

            // Perform full login
            LoginService loginService = new LoginService();
            LoginResponse loginResponse = loginService.login(AppConfig.getEmail(), AppConfig.getPassword());
            AppConfig.updateBearerToken(loginResponse.getToken());
            AppConfig.updateRefreshToken(loginResponse.getRefreshToken());

            System.out.println("Login successful and tokens updated.");
        } else {
            System.out.println("Token is valid and user is unchanged. Proceeding.");
        }
    }
}



