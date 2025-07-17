package com.vabro.api;

import com.vabro.api.Login.GeoDataRequest;
import com.vabro.api.Organization.CreateOrganization.OrganizationAddRequest;
import com.vabro.utils.JsonUtils;
import com.vabro.utils.RestClient;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class OrganizationService {

   private static final String ORG_LIST_ENDPOINT = "/api/Organization/list";

   private static final String ORG_LIST_USER_ROLES_ENDPOINT = "/api/Organization/list-user-roles";

   private static final String IS_VALID_ORG_ENDPOINT = "/api/Organization/is-valid-organization-name";

   private static final String IS_VALID_ORG_WITHID_ENDPOINT = "/api/Organization/validate-organization-name";

   private static final String CHECK_PUBLIC_DOMAIN_ENDPOINT = "/api/Organization/check-public-domain";

   private static final String ADD_ORGANIZATION_ENDPOINT = "/api/Organization/add";

   public Response ListOfOrganization()
   {
      Response response = RestClient.sendGetRequestWithToken(ORG_LIST_ENDPOINT);

      return response;
   }


   public Response ListOfOrganizationUsersRoles(Map<String, List<String>> queryParams)
   {

      Response response = RestClient.sendGetRequestWithParams(ORG_LIST_USER_ROLES_ENDPOINT, queryParams);

      return response;
   }

public Response IsValidOrgName(Map<String, String> queryParams)
   {
   Response response = RestClient.sendGetRequestWithParams(IS_VALID_ORG_ENDPOINT, queryParams.toString());

   return response;
   }

   public Response IsValidOrgByIdANDName(Map<String, String> queryParams)
   {
      Response response = RestClient.sendGetRequestWithParams(IS_VALID_ORG_WITHID_ENDPOINT, queryParams.toString());

      return response;
   }

   public Response VerifyPublicDomain(String qParam)
   {
      Response response = RestClient.sendGetRequestWithParams(CHECK_PUBLIC_DOMAIN_ENDPOINT, qParam);

      return response;
   }

   public Response AddOrganization(String orgName, String orgEmailId, String orgDomailUrl, String orgWebsite, String orgEmployee, Integer orgIndustryId)
   {
      OrganizationAddRequest qa = new OrganizationAddRequest();
      qa.setOrganizationName(orgName);
      qa.setOrganizationEmailId(orgEmailId);
      qa.setDomainURL(orgDomailUrl);
      qa.setWebsite(orgWebsite);
      qa.setSizeOfOrganization(orgEmployee);
      qa.setIndustryTypeId(orgIndustryId);

      GeoDataRequest geoDataRequest = new GeoDataRequest();
      geoDataRequest.setIpAddress("");
      geoDataRequest.setCountry("India");
      geoDataRequest.setState("Odisha");
      geoDataRequest.setCity("Bhubaneswar");
      geoDataRequest.setTimeZone("");

      qa.setGeoDataRequest(geoDataRequest);

      String requestBody = JsonUtils.toJson(qa);

      Response response =  RestClient.sendPostRequestWithToken(ADD_ORGANIZATION_ENDPOINT, requestBody);

      return response;
   }
}
