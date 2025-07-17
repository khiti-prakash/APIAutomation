package com.vabro.api;

import com.vabro.api.AutoLogin.AutoLoginResponse;
import com.vabro.utils.JsonUtils;
import com.vabro.utils.RestClient;
import config.AppConfig;
import io.restassured.response.Response;

import java.util.Map;

public class AutoLoginService {

    private static final String ENDPOINT = "/api/Account/auto-login";

    public AutoLoginResponse autoLoginWithPayload(Map<String, Object> payload) {

        Response response = RestClient.sendPostRequestWithToken(ENDPOINT, JsonUtils.toJson(payload));
        return JsonUtils.fromJson(response.getBody().asString(), AutoLoginResponse.class);
    }

    public int autoLoginStatusCode(Map<String, Object> payload) {
        Response response = RestClient.sendPostRequest(ENDPOINT, JsonUtils.toJson(payload));
        return response.statusCode();
    }
}
