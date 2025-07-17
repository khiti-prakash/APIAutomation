package com.vabro.api.Organization.CreateOrganization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrgAddResponseMessage {
    @SerializedName("responseCode")
    @Expose
    private Integer responseCode;

    @SerializedName("responseType")
    @Expose
    private String responseType;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("message")
    @Expose
    private String message;

    public Integer getResponseCode()
    {
        return responseCode;
    }
    public void setResponseCode(Integer value)
    {
        this.responseCode = value;
    }

    public String getResponseType()
    {
        return responseType;
    }
    public void setResponseType(String value)
    {
        this.responseType = value;
    }

    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String value)
    {
        this.language = value;
    }

    public String getMessage()
    {
        return message;
    }
    public void setMessage(String value)
    {
        this.message = value;
    }
}
