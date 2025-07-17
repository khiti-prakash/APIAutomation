package com.vabro.api.CreateAccount;


import java.util.List;

public class CreateAccountResponse {

    private List<ResponseMessages> responseMessages;

    public CreateAccountResponse()
    {

    }

    public List<ResponseMessages> getResponseMessages() {
        return responseMessages;
    }

    public void setResponseMessages(List<ResponseMessages> responseMessages) {
        this.responseMessages = responseMessages;
    }
}
