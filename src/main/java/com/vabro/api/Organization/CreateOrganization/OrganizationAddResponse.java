package com.vabro.api.Organization.CreateOrganization;

import java.util.List;

public class OrganizationAddResponse {
    private String status;
    private Object organizationEmailID;
    private List<OrgAddResponseMessage> responseMessages;

    public String getStatus()
    {
        return status;
    }
    public void setStatus(String value)
    {
        this.status = value;
    }

    public Object getOrganizationEmailID()
    {
        return organizationEmailID;
    }
    public void setOrganizationEmailID(Object value)
    {
        this.organizationEmailID = value;
    }

    public List<OrgAddResponseMessage> getResponseMessages()
    {
        return responseMessages;
    }
    public void setResponseMessages(List<OrgAddResponseMessage> value)
    {
        this.responseMessages = value;
    }
}

