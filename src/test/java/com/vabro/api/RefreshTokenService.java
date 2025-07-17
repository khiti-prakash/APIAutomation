package com.vabro.api;

import com.vabro.api.RefreshToken.RefreshTokenResponse;
import com.vabro.utils.JsonUtils;
import com.vabro.utils.RestClient;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class RefreshTokenService {
    private static final String ENDPOINT = "/api/Account/refresh-token";

    public RefreshTokenResponse refreshWithPayload(Map<String, Object> payload) {
        Response response = RestClient.sendPostRequest(ENDPOINT, JsonUtils.toJson(payload));
        return JsonUtils.fromJson(response.getBody().asString(), RefreshTokenResponse.class);
    }

    public int getStatusCode(Map<String, Object> payload) {
        Response response = RestClient.sendPostRequest(ENDPOINT, JsonUtils.toJson(payload));
        return response.statusCode();
    }

    public RefreshTokenResponse refreshToken(String refreshToken) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("refreshToken", refreshToken);
        payload.put("ipAddress", "127.0.0.1");         // Use real IP if needed
        payload.put("deviceType", "Desktop");

        Response response = RestClient.sendPostRequest(ENDPOINT, JsonUtils.toJson(payload));
        return JsonUtils.fromJson(response.getBody().asString(), RefreshTokenResponse.class);
    }
}
