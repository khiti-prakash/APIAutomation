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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrganizationTest {
    String emailId = "testervabro1@gmail.com";
    String password = "Test@123";
    OrganizationService organizationService;
    Response responseList;

    @Test
    @Owner("Khiti Prakash")
    @Description("Count List of Organization")
    public void testListOfOrganization(ITestContext iTestContext) {
        // Assuming you have a valid authorization token

        LoginService loginService = new LoginService();

        // Provide appropriate test credentials and data

        // Perform login and capture the response
        LoginResponse response = loginService.login(emailId, password);
        //System.out.println(response.getToken());

        String bearerToken = response.getToken();
        AppConfig.updateBearerToken(bearerToken);

        iTestContext.setAttribute("userAccountId",response.getUserAccountId());

        organizationService = new OrganizationService();
        responseList = organizationService.ListOfOrganization();

        responseList.then().log().all().statusCode(200);

        OrganizationResponse organizationResponse = JsonUtils.fromJson(responseList.getBody().asString(), OrganizationResponse.class);
        Integer orgCount = organizationResponse.getOrganizationList().size();

        iTestContext.setAttribute("userAccountId",response.getUserAccountId());
        iTestContext.setAttribute("OrganizationId",organizationResponse.getOrganizationList().get(0).getOrganizationID());


        ArrayList waitingForApproval = new ArrayList();
        ArrayList expiredOrg = new ArrayList();
        for (int i = 0; i < orgCount; i++)
        {

          //Verify Organization Id and name

            String orgId = organizationResponse.getOrganizationList().get(i).getOrganizationID();
            String orgname =organizationResponse.getOrganizationList().get(i).getOrganizationName();

            System.out.println("organization name :-"+orgname+ ","+"Organization id:-"+orgId);

            /*
                verify organization id and name should not blank
             */
            assertThat(orgId).isNotEmpty().isNotNull().isNotBlank();
            assertThat(orgname).isNotEmpty().isNotNull().isNotBlank();

             /*
                Count Expire Organization
             */

            String statusType = organizationResponse.getOrganizationList().get(i).getStatus();
            Long orgValue = organizationResponse.getOrganizationList().get(i).getOrganizationTypeID();
//            if(statusType.equalsIgnoreCase("create-organization-verify-email-expired"))
//            {
//                waitingForApproval.add(statusType);
//            }
            if(orgValue == 0)
            {
                expiredOrg.add(orgValue);
            }
            else
            {
                expiredOrg.add(orgValue);
            }
//need to add Email verification

        }

//        int waitingForApprovalOrg = waitingForApproval.size();
//        System.out.println("Waiting Org count:-"+waitingForApprovalOrg);

        int alreadyExpiredOrg = expiredOrg.size();
        System.out.println("already expired Org count:-"+alreadyExpiredOrg);
    }

}
