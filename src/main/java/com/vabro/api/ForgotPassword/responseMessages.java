package com.vabro.api.ForgotPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class responseMessages {

    @SerializedName("responseCode")
    @Expose
    private Long responseCode;

    @SerializedName("responseType")
    @Expose
    private String responseType;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("message")
    @Expose
    private String message;

    public responseMessages() {
    }

    public Long getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Long responseCode) {
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


