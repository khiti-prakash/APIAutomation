package com.vabro.api;

import com.vabro.api.Login.LoginRequest;
import com.vabro.api.Login.LoginResponse;
import com.vabro.data.VabroLoginTestData;
import com.vabro.utils.JsonUtils;
import com.vabro.utils.RestClient;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class LoginService {
    private static final String LOGIN_ENDPOINT = "/api/Account/login";


    // Method to perform login and return the login response
    public LoginResponse loginWithPayload(Map<String, Object> loginPayload) {
        Response response = RestClient.sendPostRequest(LOGIN_ENDPOINT, JsonUtils.toJson(loginPayload));
        return JsonUtils.fromJson(response.getBody().asString(), LoginResponse.class);
    }

    public LoginResponse loginWithEmptyBody() {
        return loginWithPayload(VabroLoginTestData.getBlankRequestBody());
    }

    public LoginResponse loginWithMissingField(String field) {
        return loginWithPayload(VabroLoginTestData.getLoginWithMissingField(field));
    }

    public LoginResponse loginWithPartialGeo() {
        return loginWithPayload(VabroLoginTestData.getLoginWithPartialGeo());
    }

    public LoginResponse loginWithExtraField() {
        return loginWithPayload(VabroLoginTestData.getLoginWithExtraField());
    }

    public LoginResponse loginWithInvalidTimezone() {
        return loginWithPayload(VabroLoginTestData.getLoginWithInvalidTimeZone());
    }

    public LoginResponse login(String email, String password) {
        Map<String, Object> payload = VabroLoginTestData.getValidLoginPayload();
        payload.put("emailId", email);
        payload.put("password", password);
        return loginWithPayload(payload);
    }

    public int loginUsingGetMethod() {
        return RestClient.sendGetRequest(LOGIN_ENDPOINT).getStatusCode();
    }

    public long loginWithTiming(String email, String password) {
        Map<String, Object> payload = VabroLoginTestData.getValidLoginPayload();
        payload.put("emailId", email);
        payload.put("password", password);

        long start = System.currentTimeMillis();
        RestClient.sendPostRequest(LOGIN_ENDPOINT, JsonUtils.toJson(payload));
        return System.currentTimeMillis() - start;
    }

    public boolean isCORSHeaderPresent() {
        Response response = RestClient.sendOptionsRequest(LOGIN_ENDPOINT); // assuming OPTIONS is supported
        return response.getHeaders().hasHeaderWithName("Access-Control-Allow-Origin");
    }

    public int triggerLoginRateLimit(String email, String password) {
        int status = 0;
        for (int i = 0; i < 15; i++) {
            Map<String, Object> payload = VabroLoginTestData.getValidLoginPayload();
            payload.put("emailId", email);
            payload.put("password", password);
            status = RestClient.sendPostRequest(LOGIN_ENDPOINT, JsonUtils.toJson(payload)).getStatusCode();
        }
        return status;
    }
}
