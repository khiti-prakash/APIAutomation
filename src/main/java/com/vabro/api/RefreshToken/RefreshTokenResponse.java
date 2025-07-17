package com.vabro.api.RefreshToken;

import java.util.List;

public class RefreshTokenResponse {
    private String token;
    private String refreshToken;
    private String userAccountId;
    private List<ResponseMessage> responseMessages;

    // Getters and Setters
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

    public List<ResponseMessage> getResponseMessages() {
        return responseMessages;
    }

    public void setResponseMessages(List<ResponseMessage> responseMessages) {
        this.responseMessages = responseMessages;
    }

    // Nested static class for ResponseMessage
    public static class ResponseMessage {
        private int responseCode;
        private String responseType;
        private String language;
        private String message;

        // Getters and Setters
        public int getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(int responseCode) {
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
}