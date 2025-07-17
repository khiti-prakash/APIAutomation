package com.vabro.tests;

import com.vabro.api.ForgotPassword.ForgetPasswordResponse;
import com.vabro.api.ForgotPassword.responseMessages;
import com.vabro.api.ForgotPasswordService;
import com.vabro.utils.JsonUtils;
import config.AppConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ForgotPasswordTest {
    String emailId = "edusyschandrakanta@gmail.com";


    @Test(priority = 1)
    @Owner("khiti Prakash")
    @Description("Verify the forgot password API request by positive email id")
    public void verifyForgotPasswordPOST()
    {

        ForgotPasswordService forgotPassword= new ForgotPasswordService();

        Response response = forgotPassword.forgotPasswordPOST(emailId);

        response.then().log().all().statusCode(200);

        ForgetPasswordResponse rm = JsonUtils.fromJson(response.getBody().asString(), ForgetPasswordResponse.class);

        System.out.println(rm.getResponseMessages().get(0).getResponseCode());

        assertThat(rm.getResponseMessages().get(0).getResponseCode()).isEqualTo(2018);
        assertThat(rm.getResponseMessages().get(0).getResponseType()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("success");
        assertThat(rm.getResponseMessages().get(0).getLanguage()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("en");
        assertThat(rm.getResponseMessages().get(0).getMessage()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("Password reset link has been sent to your email address. Please check your inbox and follow the instructions to reset your password.");

    }

    @Test(priority = 2)
    @Owner("khiti Prakash")
    @Description("Verify the forgot password API request by Already sent email id")
    public void verifyNegativeForgotPasswordPOST1()
    {

        ForgotPasswordService forgotPassword= new ForgotPasswordService();

        Response response = forgotPassword.forgotPasswordPOST(emailId);

        response.then().log().all().statusCode(409);

        ForgetPasswordResponse rm = JsonUtils.fromJson(response.getBody().asString(), ForgetPasswordResponse.class);

        assertThat(rm.getResponseMessages().get(0).getResponseCode()).isNotNull().isEqualTo(2008);
        assertThat(rm.getResponseMessages().get(0).getResponseType()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("success");
        assertThat(rm.getResponseMessages().get(0).getLanguage()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("en");
        assertThat(rm.getResponseMessages().get(0).getMessage()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("Password reset link has already been sent to your email address. Please check your inbox and follow the instructions to reset your password.");

    }

    @Test(priority = 3)
    @Owner("khiti Prakash")
    @Description("Verify the forgot password API request- not providing email id")
    public void verifyNegativeForgotPasswordPOST2()
    {

        ForgotPasswordService forgotPassword= new ForgotPasswordService();

        Response response = forgotPassword.forgotPasswordPOST("");

        response.then().log().all().statusCode(400);

        ForgetPasswordResponse rm = JsonUtils.fromJson(response.getBody().asString(), ForgetPasswordResponse.class);

        assertThat(rm.getResponseMessages().get(0).getResponseCode()).isNotNull().isEqualTo(1005);
        assertThat(rm.getResponseMessages().get(0).getResponseType()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("error");
        assertThat(rm.getResponseMessages().get(0).getLanguage()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("en");
        assertThat(rm.getResponseMessages().get(0).getMessage()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("Please enter email address.");

    }

    @Test(priority = 4)
    @Owner("khiti Prakash")
    @Description("Verify the forgot password API request- providing a email id which is not register")
    public void verifyNegativeForgotPasswordPOST3()
    {

        ForgotPasswordService forgotPassword= new ForgotPasswordService();

        Response response = forgotPassword.forgotPasswordPOST("testervabro1@yopmai.com");

        response.then().log().all().statusCode(401);

        ForgetPasswordResponse rm = JsonUtils.fromJson(response.getBody().asString(), ForgetPasswordResponse.class);

        assertThat(rm.getResponseMessages().get(0).getResponseCode()).isNotNull().isEqualTo(2001);
        assertThat(rm.getResponseMessages().get(0).getResponseType()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("error");
        assertThat(rm.getResponseMessages().get(0).getLanguage()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("en");
        assertThat(rm.getResponseMessages().get(0).getMessage()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("This email address is not registered. Please use a different email address or <a href='/home/join/' class='alert-link'>Sign Up</a> for a Vabro account.");

    }

    @Test(priority = 5)
    @Owner("khiti Prakash")
    @Description("Verify the forgot password API request- Wrong email id")
    public void verifyNegativeForgotPasswordPOST4()
    {

        ForgotPasswordService forgotPassword= new ForgotPasswordService();

        Response response = forgotPassword.forgotPasswordPOST("testervabro3");

        response.then().log().all().statusCode(400);

        ForgetPasswordResponse rm = JsonUtils.fromJson(response.getBody().asString(), ForgetPasswordResponse.class);

        assertThat(rm.getResponseMessages().get(0).getResponseCode()).isNotNull().isEqualTo(1006);
        assertThat(rm.getResponseMessages().get(0).getResponseType()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("error");
        assertThat(rm.getResponseMessages().get(0).getLanguage()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("en");
        assertThat(rm.getResponseMessages().get(0).getMessage()).isNotEmpty().isNotBlank().isNotNull().isEqualTo("Please enter a valid email address.");

    }
}
