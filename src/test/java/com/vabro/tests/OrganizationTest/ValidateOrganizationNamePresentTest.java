package com.vabro.tests.OrganizationTest;

import com.vabro.api.Login.LoginResponse;
import com.vabro.api.LoginService;
import com.vabro.api.Organization.ValidOrganizationNameResponse;
import com.vabro.api.OrganizationService;
import com.vabro.utils.JsonUtils;
import config.AppConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ValidateOrganizationNamePresentTest {
    String emailId = "testervabro1@gmail.com";
    String password = "Test@123";

    OrganizationService organizationService;

    @Test
    @Owner("Khiti Prakash")
    @Description("Count List of Organization")
    public void login(ITestContext iTestContext)
    {
        // Assuming you have a valid authorization token

        LoginService loginService = new LoginService();

        // Provide appropriate test credentials and data

        // Perform login and capture the response
        LoginResponse response = loginService.login(emailId, password);
        //System.out.println(response.getToken());

        String bearerToken = response.getToken();

        AppConfig.updateBearerToken(bearerToken);
        iTestContext.setAttribute("userAccountId",response.getUserAccountId());


    }

    @Test(dependsOnMethods = {"login"})
    @Owner("Khiti Prakash")
    public void validateOrganizationName()
    {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("OrganizationName","Automation");
        //queryParams.put("OrganizationName","Board Checking");

        organizationService = new OrganizationService();

        Response response = organizationService.IsValidOrgName(queryParams);

        response.then().statusCode(200);

        ValidOrganizationNameResponse validOrganizationNameResponse  = JsonUtils.fromJson(response.getBody().asString(), ValidOrganizationNameResponse.class);

        Boolean isOrgPresent = validOrganizationNameResponse.isOrganizationExists();
        Boolean isOrgPending = validOrganizationNameResponse.isVerificationPending();

        System.out.println(queryParams.get("OrganizationName")+" organization is present :- "+isOrgPresent);
        System.out.println(queryParams.get("OrganizationName")+" organization is verification pending :- "+isOrgPending);
    }


}
