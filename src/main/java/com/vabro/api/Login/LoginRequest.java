package com.vabro.api.Login;

import com.google.gson.annotations.*;
import com.google.gson.annotations.*;

import java.util.List;

public class LoginRequest {

    @SerializedName("emailId")
    @Expose
    private String emailId;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("ipAddress")
    @Expose
    private String ipAddress;

    @SerializedName("timeZone")
    @Expose
    private String timeZone;

    @SerializedName("deviceType")
    @Expose
    private String deviceType;

    @SerializedName("geoData")
    @Expose
    private String GeoDataRequest;


    public LoginRequest() {
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getGeoDataRequest() {
        return GeoDataRequest;
    }

    public void setGeoDataRequest(String geoDataRequest) {
        GeoDataRequest = geoDataRequest;
    }
}
