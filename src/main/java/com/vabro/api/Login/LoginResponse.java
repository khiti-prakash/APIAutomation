package com.vabro.api.Login;

import com.google.gson.annotations.*;
import com.google.gson.annotations.*;

import java.util.List;

public class LoginResponse {

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("refreshToken")
    @Expose
    private String refreshToken;

    @SerializedName("userAccountId")
    @Expose
    private String userAccountId;

    @SerializedName("responseMessages")
    @Expose
    private List<LoginResponseMessage> loginResponseMessage;

    public LoginResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    public List<LoginResponseMessage> getLoginResponseMessage() {
        return loginResponseMessage;
    }

    public void setLoginResponseMessage(List<LoginResponseMessage> loginResponseMessage) {
        this.loginResponseMessage = loginResponseMessage;
    }
}
