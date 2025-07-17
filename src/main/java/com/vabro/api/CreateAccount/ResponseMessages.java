package com.vabro.api.CreateAccount;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseMessages {

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


    ResponseMessages()
    {

    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
