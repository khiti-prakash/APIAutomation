package com.vabro.api;

import com.vabro.api.ForgotPassword.ForgotPasswordRequest;
import com.vabro.api.ForgotPassword.responseMessages;
import com.vabro.api.Login.LoginResponse;
import com.vabro.utils.JsonUtils;
import com.vabro.utils.RestClient;
import io.restassured.response.Response;

public class ForgotPasswordService {

    private static final String LOGIN_ENDPOINT = "/api/Account/forgot-password";

    public Response forgotPasswordPOST(String emailId)
    {
        ForgotPasswordRequest forgotPasswordRequest= new ForgotPasswordRequest();

        forgotPasswordRequest.setEmailId(emailId);

        // Convert the LoginRequest object to JSON
        String requestBody = JsonUtils.toJson(forgotPasswordRequest);

        // Send POST request to the login endpoint
        Response response = RestClient.sendPostRequest(LOGIN_ENDPOINT, requestBody);

        return response;
       // return JsonUtils.fromJson(response.getBody().asString(), responseMessages.class);
    }
}
