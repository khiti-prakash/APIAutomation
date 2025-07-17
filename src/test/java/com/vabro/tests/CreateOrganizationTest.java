package com.vabro.tests;

import com.vabro.api.Login.LoginResponse;
import com.vabro.api.LoginService;
import com.vabro.api.Organization.CreateOrganization.OrganizationAddResponse;
import com.vabro.api.OrganizationService;
import com.vabro.utils.JsonUtils;
import config.AppConfig;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateOrganizationTest {

    String emailId = "testervabro1@gmail.com";
    String password = "Test@123";

    OrganizationService organizationService;

    @Test
    @Owner("Khiti Prakash")
    @Description("Create an Organization")
    public void login(ITestContext iTestContext) {
        // Assuming you have a valid authorization token

        LoginService loginService = new LoginService();

        // Provide appropriate test credentials and data

        // Perform login and capture the response
        LoginResponse response = loginService.login(emailId, password);
        //System.out.println(response.getToken());

        String bearerToken = response.getToken();

        AppConfig.updateBearerToken(bearerToken);

    }
    @Test(dependsOnMethods = {"login"})
    @Owner("Khiti Prakash")
    public void CreateNewOrganization()
    {
        String organizationName = "API Automation-112";
        String EmailAddress = "testervabro1@gmail.com";
        String EmailDomain = "gmail.com";
        String Website = "https://www.google.com";
        String NumberOfEmployee = "1-10";  //value="1-10",value="11-50",value="51-200", value="201-500", value="1001-5000", value="5001-10000", value="10000+"
        Integer Industry = 0; // industry Type id start from 0 and end with 13

        organizationService = new OrganizationService();

       Response response = organizationService.AddOrganization(organizationName,EmailAddress,EmailDomain, Website,NumberOfEmployee,Industry);

        response.then().statusCode(200);

        OrganizationAddResponse organizationAddResponse  = JsonUtils.fromJson(response.getBody().asString(), OrganizationAddResponse.class);

        assertThat(organizationAddResponse.getStatus())
                .isNotBlank().isNotNull().isNotEmpty().isEqualTo("email-sent");

        assertThat(organizationAddResponse.getResponseMessages().get(0).getResponseCode())
                .isNotNull().isNotNegative().isEqualTo(2111);

        assertThat(organizationAddResponse.getResponseMessages().get(0)
                .getResponseType()).isNotNull().isNotEmpty().isNotBlank().isEqualTo("success");

        assertThat(organizationAddResponse.getResponseMessages().
                get(0).getLanguage()).isNotNull().isNotBlank().isNotEmpty().isEqualTo("en");

        assertThat(organizationAddResponse.getResponseMessages().
                get(0).getMessage()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("email sent");

    }

    @Test(dependsOnMethods = {"CreateNewOrganization"})
    @Owner("Khiti Prakash")
    @Description("Verify Organization is already exist")
    public void VerifyOrganizationExist()
    {
        String organizationName = "API Automation-5";
        String EmailAddress = "testervabro1@gmail.com";
        String EmailDomain = "gmail.com";
        String Website = "https://www.google.com";
        String NumberOfEmployee = "1-10";  //value="1-10",value="11-50",value="51-200", value="201-500", value="1001-5000", value="5001-10000", value="10000+"
        Integer Industry = 0; // industry Type id start from 0 and end with 13

        organizationService = new OrganizationService();

        Response response = organizationService.AddOrganization(organizationName,EmailAddress,EmailDomain, Website,NumberOfEmployee,Industry);

        response.then().statusCode(200);

        OrganizationAddResponse organizationAddResponse  = JsonUtils.fromJson(response.getBody().asString(), OrganizationAddResponse.class);

        assertThat(organizationAddResponse.getStatus())
                .isNotBlank().isNotNull().isNotEmpty().isEqualTo("organization-exists");

        assertThat(organizationAddResponse.getResponseMessages().get(0).getResponseCode())
                .isNotNull().isNotNegative().isEqualTo(2107);

        assertThat(organizationAddResponse.getResponseMessages().get(0)
                .getResponseType()).isNotNull().isNotEmpty().isNotBlank().isEqualTo("error");

        assertThat(organizationAddResponse.getResponseMessages().
                get(0).getLanguage()).isNotNull().isNotBlank().isNotEmpty().isEqualTo("en");

        // Need to check with smruti
        assertThat(organizationAddResponse.getResponseMessages().
                get(0).getMessage()).isNotBlank().isNotNull().isNotEmpty().isEqualTo("workspace already exists");

    }

}
