package com.vabro.api.Organization.CreateOrganization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vabro.api.Login.GeoDataRequest;

public class OrganizationAddRequest {

    @SerializedName("organizationName")
    @Expose
    private String organizationName;

    @SerializedName("organizationEmailId")
    @Expose
    private  String organizationEmailId;

    @SerializedName("domainURL")
    @Expose
    private String domainURL;

    @SerializedName("website")
    @Expose
    private String website;

    @SerializedName("sizeOfOrganization")
    @Expose
    private String sizeOfOrganization;

    @SerializedName("industryTypeId")
    @Expose
    private Integer industryTypeId;

    @SerializedName("geoData")
    @Expose
    private GeoDataRequest geoDataRequest;

    @SerializedName("origin")
    @Expose
    private String origin;

    @SerializedName("language")
    @Expose
    private String language;

    public OrganizationAddRequest() {
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationEmailId() {
        return organizationEmailId;
    }

    public void setOrganizationEmailId(String organizationEmailId) {
        this.organizationEmailId = organizationEmailId;
    }

    public String getDomainURL() {
        return domainURL;
    }

    public void setDomainURL(String domainURL) {
        this.domainURL = domainURL;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSizeOfOrganization() {
        return sizeOfOrganization;
    }

    public void setSizeOfOrganization(String sizeOfOrganization) {
        this.sizeOfOrganization = sizeOfOrganization;
    }

    public Integer getIndustryTypeId() {
        return industryTypeId;
    }

    public void setIndustryTypeId(Integer industryTypeId) {
        this.industryTypeId = industryTypeId;
    }

    public GeoDataRequest getGeoDataRequest() {
        return geoDataRequest;
    }

    public void setGeoDataRequest(GeoDataRequest geoDataRequest) {
        this.geoDataRequest = geoDataRequest;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
