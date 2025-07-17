package com.vabro.api;

import com.vabro.api.CreateAccount.CreateAccountRequest;
import com.vabro.api.ForgotPassword.ForgotPasswordRequest;
import com.vabro.utils.JsonUtils;
import com.vabro.utils.RestClient;
import io.restassured.response.Response;

public class CreateAccountService {

    private static final String CREATE_ACCOUNT_ENDPOINT = "/api/Account/register";

    public Response createAccount(String emailId)
    {
        ForgotPasswordRequest forgotPasswordRequest = new ForgotPasswordRequest();
        forgotPasswordRequest.setEmailId(emailId);

        String requestBody = JsonUtils.toJson(forgotPasswordRequest);

        Response response = RestClient.sendPostRequest(CREATE_ACCOUNT_ENDPOINT,requestBody);

        return response;
    }

    public Response createAccount(String emailId, String country, String state, String city, String origin, String language)
    {
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setEmailId(emailId);
        createAccountRequest.setCountry(country);
        createAccountRequest.setState(state);
        createAccountRequest.setCity(city);
        createAccountRequest.setOrigin(origin);
        createAccountRequest.setLanguage(language);


        String requestBody = JsonUtils.toJson(createAccountRequest);

        Response response = RestClient.sendPostRequest(CREATE_ACCOUNT_ENDPOINT,requestBody);

        return response;
    }
}
