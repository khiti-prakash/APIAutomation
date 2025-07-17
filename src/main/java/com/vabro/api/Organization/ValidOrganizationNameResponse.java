package com.vabro.api.Organization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ValidOrganizationNameResponse {

    @SerializedName("organizationExists")
    @Expose
    private boolean organizationExists;

    @SerializedName("verificationPending")
    @Expose
    private boolean verificationPending;


    @SerializedName("responseMessages")
    @Expose
    private List<ValidateOrganizationNameResponse> validateOrganizationNameResponses;


    public ValidOrganizationNameResponse()
    {

    }

    public boolean isOrganizationExists() {
        return organizationExists;
    }

    public void setOrganizationExists(boolean organizationExists) {
        this.organizationExists = organizationExists;
    }

    public boolean isVerificationPending() {
        return verificationPending;
    }

    public void setVerificationPending(boolean verificationPending) {
        this.verificationPending = verificationPending;
    }

    public List<ValidateOrganizationNameResponse> getValidateOrganizationNameResponses() {
        return validateOrganizationNameResponses;
    }

    public void setValidateOrganizationNameResponses(List<ValidateOrganizationNameResponse> validateOrganizationNameResponses) {
        this.validateOrganizationNameResponses = validateOrganizationNameResponses;
    }
}
