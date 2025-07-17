package com.vabro.api.Organization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDetailResponse {
    @SerializedName("userAccountId")
    @Expose
    private String userAccountId;

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("emailId")
    @Expose
    private String emailId;

    @SerializedName("phoneNumber")
    @Expose
    private Object phoneNumber;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("timeZone")
    @Expose
    private String timeZone;

    @SerializedName("dateOfBirth")
    @Expose
    private Object dateOfBirth;

    @SerializedName("photo")
    @Expose
    private String photo;

    @SerializedName("countryCode")
    @Expose
    private Object countryCode;

    @SerializedName("joinDate")
    @Expose
    private String joinDate;

    @SerializedName("statusId")
    @Expose
    private long statusId;

    @SerializedName("organizationUserStatusId")
    @Expose
    private long organizationUserStatusId;

    public String getUserAccountID()
    {
        return userAccountId;
    }
    public void setUserAccountID(String value)
    {
        this.userAccountId = value;
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

    public String getEmailID()
    {
        return emailId;
    }
    public void setEmailID(String value)
    {
        this.emailId = value;
    }

    public Object getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setPhoneNumber(Object value)
    {
        this.phoneNumber = value;
    }

    public String getCountry()
    {
        return country;
    }
    public void setCountry(String value)
    {
        this.country = value;
    }

    public String getTimeZone()
    {
        return timeZone;
    }
    public void setTimeZone(String value)
    {
        this.timeZone = value;
    }

    public Object getDateOfBirth()
    {
        return dateOfBirth;
    }
    public void setDateOfBirth(Object value)
    {
        this.dateOfBirth = value;
    }

    public String getPhoto()
    {
        return photo;
    }
    public void setPhoto(String value)
    {
        this.photo = value;
    }

    public Object getCountryCode()
    { return countryCode;
    }
    public void setCountryCode(Object value)
    {
        this.countryCode = value;
    }

    public long getOrganizationUserStatusID() {
        return organizationUserStatusId;
    }

    public void setOrganizationUserStatusID(long organizationUserStatusId) {
        this.organizationUserStatusId = organizationUserStatusId;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
}
