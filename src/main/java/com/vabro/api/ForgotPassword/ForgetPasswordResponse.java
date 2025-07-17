package com.vabro.api.ForgotPassword;

import java.util.List;

public class ForgetPasswordResponse {
    private List<responseMessages> responseMessages;

    public List<responseMessages> getResponseMessages() {
        return responseMessages;
    }

    public void setResponseMessages(List<responseMessages> value) {
        this.responseMessages = value;
    }
}
