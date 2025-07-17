package com.vabro.tests.OrganizationTest;

import com.vabro.api.Login.LoginResponse;
import com.vabro.api.LoginService;
import com.vabro.api.Organization.OrganizationResponse;
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

public class ValidateOrgNameWithIdPresentTest {
    String emailId = "testervabro1@gmail.com";
    String password = "Test@123";

    OrganizationService organizationService;
    Response responseList;
    //List arrList = new ArrayList();
    Map<String, String> item = new HashMap<String, String>();

    @Test
    @Owner("Khiti Prakash")
    @Description("Count List of Organization")
    public void GetTokenAndOrgIDAndName(ITestContext iTestContext)
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

        //Get List of Org id and name

        organizationService = new OrganizationService();
        responseList = organizationService.ListOfOrganization();

        OrganizationResponse organizationResponse = JsonUtils.fromJson(responseList.getBody().asString(), OrganizationResponse.class);

        for(int i =0; i<organizationResponse.getOrganizationList().size(); i++)
        {
            String orgName = organizationResponse.getOrganizationList().get(i).getOrganizationName();
            String orgId = organizationResponse.getOrganizationList().get(i).getOrganizationID();

            item.put(orgName, orgId);
        }

        // Store the map in ITestContext so it can be accessed later
        iTestContext.setAttribute("organizationData", item);

    }

    @Test(dependsOnMethods = {"GetTokenAndOrgIDAndName"})
    @Owner("Khiti Prakash")
    public void verifyOrgPresentById(ITestContext iTestContext)
    {
        Map<String, String> retrievedItem = (Map<String, String>) iTestContext.getAttribute("organizationData");


        organizationService = new OrganizationService();
        for (int i =0; i<retrievedItem.size(); i++)
        {
            Response list = organizationService.IsValidOrgByIdANDName(retrievedItem);

            list.then().statusCode(200);

            list.then().log().all();
        }


    }
}
