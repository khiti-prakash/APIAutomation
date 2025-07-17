package com.vabro.api.Organization;

import java.util.List;

public class OrganizationResponse {

    private List<OrganizationListResponse> organizationList;
    private List<Object> responseMessages;
    private String userAccountID;
    private String emailID;
    private String firstName;
    private String lastName;
    private List<RoleResponse> roles;
    private UserDetailResponse userDetail;
   // private List<Object> workDetails;


    public List<OrganizationListResponse> getOrganizationList()
    {
        return organizationList;
    }
    public void setOrganizationList(List<OrganizationListResponse> value)
    {
        this.organizationList = value;
    }

    public List<Object> getResponseMessages() {
        return responseMessages;
    }
    public void setResponseMessages(List<Object> value)
    {
        this.responseMessages = value;
    }

    public String getUserAccountID()
    {
        return userAccountID;
    }
    public void setUserAccountID(String value)
    {
        this.userAccountID = value;
    }

    public String getEmailID()
    {
        return emailID;
    }
    public void setEmailID(String value)
    {
        this.emailID = value;
    }

    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String value)
    {
        this.firstName = value;
    }

    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String value)
    {
        this.lastName = value;
    }

    public List<RoleResponse> getRoles()
    {
        return roles;
    }
    public void setRoles(List<RoleResponse> value)
    {
        this.roles = value;
    }


    public UserDetailResponse getUserDetail()
    {
        return userDetail;
    }
    public void setUserDetail(UserDetailResponse value)
    {
        this.userDetail = value;
    }
}
