package com.vabro.tests.ReusableAPI;

import com.vabro.api.Login.LoginResponse;
import com.vabro.api.LoginService;
import com.vabro.api.RefreshToken.RefreshTokenResponse;
import com.vabro.api.RefreshTokenService;
import com.vabro.data.VabroLoginTestData;
import com.vabro.utils.JwtUtils;
import config.AppConfig;
import org.testng.annotations.BeforeClass;

import java.util.Map;

public class BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setupToken() {
        String token = AppConfig.getBearerToken();
        String refreshToken = AppConfig.getRefreshToken();

        boolean tokenExpired = token == null || token.isEmpty() || JwtUtils.isTokenExpired(token);
        boolean userChanged = false;

        if (token != null && !token.isEmpty()) {
            String userIdFromToken = JwtUtils.getUserIdFromToken(token);
            // You can match this to a known expected user ID or just force update if email changed
            // Example logic (optional): decode and compare email ID if present
            userChanged = !userIdFromToken.equals(AppConfig.EMAIL_ID);  // assuming userId = email
        }

        if (tokenExpired || userChanged) {
            System.out.println("Token is expired or user has changed. Proceeding to login...");

            // Refresh token logic (optional)
            if (!tokenExpired && refreshToken != null && !refreshToken.isEmpty()) {
                System.out.println("Trying to refresh the token...");
                RefreshTokenService refreshService = new RefreshTokenService();
                RefreshTokenResponse response = refreshService.refreshToken(refreshToken);

                if (response != null && response.getToken() != null && !response.getToken().isEmpty()) {
                    AppConfig.updateBearerToken(response.getToken());
                    AppConfig.updateRefreshToken(response.getRefreshToken());
                    System.out.println("Tokens refreshed successfully.");
                    return;
                } else {
                    System.out.println("Refresh failed. Proceeding to full login.");
                }
            }

            // Full login
            LoginService loginService = new LoginService();
            LoginResponse loginResponse = loginService.login(AppConfig.EMAIL_ID, AppConfig.PASSWORD);

            AppConfig.updateBearerToken(loginResponse.getToken());
            AppConfig.updateRefreshToken(loginResponse.getRefreshToken());

            System.out.println("Login successful and tokens updated.");
        } else {
            System.out.println("Token is valid and belongs to correct user. Proceeding.");
        }
    }
}



