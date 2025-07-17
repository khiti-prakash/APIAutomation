package com.vabro.utils;

import com.vabro.api.Login.LoginResponse;
import com.vabro.api.LoginService;
import com.vabro.data.VabroLoginTestData;
import config.AppConfig;

public class TokenManager {
    public static String getToken() {
        String token = AppConfig.getBearerToken();
        String refreshToken = AppConfig.getRefreshToken();

        if (token == null || token.isEmpty() || JwtUtils.isTokenExpired(token)) {
            System.out.println("Token is missing or expired. Fetching new token...");

            LoginResponse response = new LoginService().loginWithPayload(VabroLoginTestData.getValidLoginPayload());

            if (response != null && response.getToken() != null) {
                token = response.getToken();
                refreshToken=response.getRefreshToken();
                AppConfig.updateBearerToken(token);
                AppConfig.updateRefreshToken(refreshToken);
            } else {
                throw new RuntimeException("Failed to fetch a valid token from LoginService.");
            }
        }

        return token;
    }
}
