package com.vabro.api.ForgotPassword;

public class ForgotPasswordRequest {

    private String emailId;
    private String origin;
    private String language;

    public ForgotPasswordRequest()
    {

    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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
