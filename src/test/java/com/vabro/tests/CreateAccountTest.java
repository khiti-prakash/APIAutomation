package com.vabro.tests;

import com.vabro.api.CreateAccount.CreateAccountResponse;
import com.vabro.api.CreateAccountService;
import com.vabro.utils.JsonUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateAccountTest {
    String emailId = "testervabro10.50@yopmail.com";
    String exist_emailId = "testervabro1@gmail.com";
    String country ="India";
    String state = "Odisha";
    String city = "Bhubaneswar";
    String origin= "";
    String language ="en";

    @Test
    @Owner("Khiti Prakash Rout")
    @Description("Test the API with new Email id")
    public void testVerifyCreateAccountPOST1()
    {
       CreateAccountService createAccountService = new CreateAccountService();
        Response response = createAccountService.createAccount(emailId);

        response.then().log().all().statusCode(200);

         CreateAccountResponse createAccountResponse = JsonUtils.fromJson(response.getBody().asString(), CreateAccountResponse.class);

        assertThat(createAccountResponse.getResponseMessages().get(0).getResponseCode()).isNotNull().isEqualTo(2011);
        assertThat(createAccountResponse.getResponseMessages().get(0).getResponseType()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("success");
        assertThat(createAccountResponse.getResponseMessages().get(0).getLanguage()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("en");
        assertThat(createAccountResponse.getResponseMessages().get(0).getMessage()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("Registration successful, please check your email for verification instructions.");
    }

    @Test
    @Owner("Khiti Prakash Rout")
    @Description("Test the API with Email id with all the data")
    public void testVerifyNegativeCreateAccountPOST1()
    {
        CreateAccountService createAccountService = new CreateAccountService();
        Response response = createAccountService.createAccount(emailId,country,state,city,origin,language);

        response.then().log().all().statusCode(200);

        CreateAccountResponse createAccountResponse = JsonUtils.fromJson(response.getBody().asString(), CreateAccountResponse.class);

        assertThat(createAccountResponse.getResponseMessages().get(0).getResponseCode()).isNotNull().isEqualTo(2011);
        assertThat(createAccountResponse.getResponseMessages().get(0).getResponseType()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("success");
        assertThat(createAccountResponse.getResponseMessages().get(0).getLanguage()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("en");
        assertThat(createAccountResponse.getResponseMessages().get(0).getMessage()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("Registration successful, please check your email for verification instructions.");
    }

    @Test
    @Owner("Khiti Prakash Rout")
    @Description("Test the API with Already exist Email id")
    public void testVerifyNegativeCreateAccountPOST3()
    {
        CreateAccountService createAccountService = new CreateAccountService();
        Response response = createAccountService.createAccount(exist_emailId);

        response.then().log().all().statusCode(409);

        CreateAccountResponse createAccountResponse = JsonUtils.fromJson(response.getBody().asString(), CreateAccountResponse.class);

        assertThat(createAccountResponse.getResponseMessages().get(0).getResponseCode()).isNotNull().isEqualTo(2012);
        assertThat(createAccountResponse.getResponseMessages().get(0).getResponseType()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("error");
        assertThat(createAccountResponse.getResponseMessages().get(0).getLanguage()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("en");
        assertThat(createAccountResponse.getResponseMessages().get(0).getMessage()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("A Vabro account is already registered with this email address. Please use a different email address or Login to your account.");
    }

    @Test
    @Owner("Khiti Prakash Rout")
    @Description("Test the API with providing blank in Email id field")
    public void testVerifyNegativeCreateAccountPOST4()
    {
        CreateAccountService createAccountService = new CreateAccountService();
        Response response = createAccountService.createAccount("");

        response.then().log().all().statusCode(400);

        CreateAccountResponse createAccountResponse = JsonUtils.fromJson(response.getBody().asString(), CreateAccountResponse.class);

        assertThat(createAccountResponse.getResponseMessages().get(0).getResponseCode()).isNotNull().isEqualTo(1005);
        assertThat(createAccountResponse.getResponseMessages().get(0).getResponseType()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("error");
        assertThat(createAccountResponse.getResponseMessages().get(0).getLanguage()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("en");
        assertThat(createAccountResponse.getResponseMessages().get(0).getMessage()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("Please enter email address.");
    }

    @Test
    @Owner("Khiti Prakash Rout")
    @Description("Test the API with providing wrong Email")
    public void testVerifyNegativeCreateAccountPOST5()
    {
        CreateAccountService createAccountService = new CreateAccountService();
        Response response = createAccountService.createAccount("testvabro1");

        response.then().log().all().statusCode(400);

        CreateAccountResponse createAccountResponse = JsonUtils.fromJson(response.getBody().asString(), CreateAccountResponse.class);

        assertThat(createAccountResponse.getResponseMessages().get(0).getResponseCode()).isNotNull().isEqualTo(1006);
        assertThat(createAccountResponse.getResponseMessages().get(0).getResponseType()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("error");
        assertThat(createAccountResponse.getResponseMessages().get(0).getLanguage()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("en");
        assertThat(createAccountResponse.getResponseMessages().get(0).getMessage()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("Please enter a valid email address.");
    }
}
