package com.vabro.api.Organization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckPublicDomainResponse {

    @SerializedName("isPublicDomain")
    @Expose
    private boolean isPublicDomain;


    public CheckPublicDomainResponse()
    {

    }

    public void setPublicDomain(boolean isPublicDomain)
    {
        this.isPublicDomain = isPublicDomain;

    }

    public boolean getPublicDomain()
    {
        return isPublicDomain;
    }
}
