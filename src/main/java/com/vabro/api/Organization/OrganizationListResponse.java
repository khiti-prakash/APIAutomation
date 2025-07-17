package com.vabro.api.Organization;

import com.google.gson.annotations.*;
import com.google.gson.annotations.*;

import java.text.DateFormat;
import java.time.OffsetDateTime;
import java.util.Date;

public class OrganizationListResponse {

    @SerializedName("organizationId")
    @Expose
    private String organizationId;

    @SerializedName("organizationName")
    @Expose
    private String organizationName;

    @SerializedName("organizationEmailID")
    @Expose
    private Object organizationEmailId;

    @SerializedName("domainURL")
    @Expose
    private Object domainURL;

    @SerializedName("website")
    @Expose
    private Object website;

    @SerializedName("logo")
    @Expose
    private String logo;

    @SerializedName("subscriptionTypeId")
    @Expose
    private Long subscriptionTypeId;

    @SerializedName("subscriptionId")
    @Expose
    private Object subscriptionId;

    @SerializedName("joinDate")
    @Expose
    private String joinDate;

    @SerializedName("ipAddress")
    @Expose
    private Object ipAddress;

    @SerializedName("county")
    @Expose
    private Object county;

    @SerializedName("state")
    @Expose
    private Object state;

    @SerializedName("city")
    @Expose
    private Object city;

    @SerializedName("organizationTypeId")
    @Expose
    private Long organizationTypeId;

    @SerializedName("industryTypeId")
    @Expose
    private Long industryTypeId;

    @SerializedName("sizeOfOrganization")
    @Expose
    private Object sizeOfOrganization;

    @SerializedName("timeZone")
    @Expose
    private Object timeZone;

    @SerializedName("noOfWorkspace")
    @Expose
    private Long noOfWorkspace;

    @SerializedName("organizationOptions")
    @Expose
    private Object organizationOptions;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("roleId")
    @Expose
    private Long roleId;

    @SerializedName("requestId")
    @Expose
    private Long requestId;

    @SerializedName("securityMatrix")
    @Expose
    private SecurityMatrixResponse securityMatrix;

    @SerializedName("subscription")
    @Expose
    private Object subscription;


    public OrganizationListResponse() {
    }

    public String getOrganizationID() {
        return organizationId;
    }

    public void setOrganizationID(String organizationID) {
        this.organizationId = organizationID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Object getOrganizationEmailID() {
        return organizationEmailId;
    }

    public void setOrganizationEmailID(Object organizationEmailId) {
        this.organizationEmailId = organizationEmailId;
    }

    public Object getDomainURL() {
        return domainURL;
    }

    public void setDomainURL(Object domainURL) {
        this.domainURL = domainURL;
    }

    public Object getWebsite() {
        return website;
    }

    public void setWebsite(Object website) {
        this.website = website;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Long getSubscriptionTypeID() {
        return subscriptionTypeId;
    }

    public void setSubscriptionTypeID(Long subscriptionTypeID) {
        this.subscriptionTypeId = subscriptionTypeID;
    }

    public Object getSubscriptionID() {
        return subscriptionId;
    }

    public void setSubscriptionID(Object subscriptionID) {
        this.subscriptionId = subscriptionID;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public Object getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(Object ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Object getCounty() {
        return county;
    }

    public void setCounty(Object county) {
        this.county = county;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Long getOrganizationTypeID() {
        return organizationTypeId;
    }

    public void setOrganizationTypeID(Long organizationTypeId) {
        this.organizationTypeId = organizationTypeId;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Long getIndustryTypeID() {
        return industryTypeId;
    }

    public void setIndustryTypeID(Long industryTypeId) {
        this.industryTypeId = industryTypeId;
    }

    public Object getSizeOfOrganization() {
        return sizeOfOrganization;
    }

    public void setSizeOfOrganization(Object sizeOfOrganization) {
        this.sizeOfOrganization = sizeOfOrganization;
    }

    public Object getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Object timeZone) {
        this.timeZone = timeZone;
    }

    public Long getNoOfWorkspace() {
        return noOfWorkspace;
    }

    public void setNoOfWorkspace(Long noOfWorkspace) {
        this.noOfWorkspace = noOfWorkspace;
    }

    public Object getOrganizationOptions() {
        return organizationOptions;
    }

    public void setOrganizationOptions(Object organizationOptions) {
        this.organizationOptions = organizationOptions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRoleID() {
        return roleId;
    }

    public void setRoleID(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRequestID() {
        return requestId;
    }

    public void setRequestID(Long requestId) {
        this.requestId = requestId;
    }

    public SecurityMatrixResponse getSecurityMatrix() {
        return securityMatrix;
    }

    public void setSecurityMatrix(SecurityMatrixResponse securityMatrix) {
        this.securityMatrix = securityMatrix;
    }

    public Object getSubscription() {
        return subscription;
    }

    public void setSubscription(Object subscription) {
        this.subscription = subscription;
    }
}
