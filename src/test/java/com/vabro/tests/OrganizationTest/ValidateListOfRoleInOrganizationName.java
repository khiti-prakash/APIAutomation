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

import java.util.*;

public class ValidateListOfRoleInOrganizationName {
    String emailId = "testervabro1@gmail.com";
    String password = "Test@123";
    OrganizationService organizationService;
    Response responseList;

    //dependsOnMethods = {"testListOfOrganization"}
    @Test
    @Owner("Khiti Prakash")
    @Description("Count List of Organization and roles and workspace present")
    public void rolesPresentInOrganization(ITestContext iTestContext)
    {
        LoginService loginService = new LoginService();
        LoginResponse loginResponseresponse = loginService.login(emailId, password);

        String bearerToken = loginResponseresponse.getToken();
        AppConfig.updateBearerToken(bearerToken);

        String userAccountId = loginResponseresponse.getUserAccountId();

        organizationService = new OrganizationService();
        responseList = organizationService.ListOfOrganization();

        OrganizationResponse organizationResponseOrgList = JsonUtils.fromJson(responseList.getBody().asString(), OrganizationResponse.class);

        // Extract list of organization IDs
        List<String> organizationsId = new ArrayList<>();
        for (int i =0; i< organizationResponseOrgList.getOrganizationList().size();i++) {
            organizationsId.add(organizationResponseOrgList.getOrganizationList().get(i).getOrganizationID());
           // organizations.add(organizationResponseOrgList.getOrganizationList().get(i).get);
        }

        // Define the endpoint and query parameters
        Map<String, List<String>> queryParams = new HashMap<>();
        queryParams.put("OrganizationId", organizationsId);
        queryParams.put("userAccountId", Arrays.asList(userAccountId));

        Response response = organizationService.ListOfOrganizationUsersRoles(queryParams);
        if (response.getStatusCode() == 200) {
            OrganizationResponse organizationResponse = JsonUtils.fromJson(response.getBody().asString(), OrganizationResponse.class);
            // Integer orgCount = organizationResponse.getOrganizationList().size();

            for (int i = 0; i < organizationResponseOrgList.getOrganizationList().size(); i++) {
                if(organizationResponse.getOrganizationList().get(i).getOrganizationTypeID() == 1){
                    //this id for Org name
                    String name = organizationResponse.getOrganizationList().get(i).getOrganizationName();
                    System.out.println(name);

                    //this id for Role name
                    for (int j = 0; j < organizationResponse.getRoles().size(); j++) {
                        String roleName = organizationResponse.getRoles().get(j).getRoleName();

                        System.out.println(roleName);
                    }
                }
            }
        }
        else
        {
            System.err.println("API failed with status code: " + response.getStatusCode());
            System.err.println("Response: " + response.getBody().asString());
        }

    }
}
