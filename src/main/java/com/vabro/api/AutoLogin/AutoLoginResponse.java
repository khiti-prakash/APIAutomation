package com.vabro.api.AutoLogin;

import java.util.List;

public class AutoLoginResponse {
    public List<ResponseMessage> responseMessages;
    public String token;
    public String refreshToken;
    public String userAccountId;

    public static class ResponseMessage {
        public int responseCode;
        public String responseType;
        public String language;
        public String message;
    }
}
