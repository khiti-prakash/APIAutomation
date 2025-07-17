package com.vabro.data;

import config.AppConfig;

import java.util.HashMap;
import java.util.Map;

public class VabroLoginTestData {

    public static Map<String, Object> getValidLoginPayload() {
        Map<String, Object> geoData = new HashMap<>();
        geoData.put("ipAddress", "192.168.1.1");
        geoData.put("country", "India");
        geoData.put("state", "Odisha");
        geoData.put("city", "Bhubaneswar");
        geoData.put("timeZone", "UTC");

        Map<String, Object> loginData = new HashMap<>();
        loginData.put("emailId", AppConfig.EMAIL_ID);
        loginData.put("password", AppConfig.PASSWORD);
        loginData.put("ipAddress", "192.168.1.1");
        loginData.put("timeZone", "UTC");
        loginData.put("deviceType", "Desktop");
        loginData.put("geoData", geoData);

        return loginData;
    }

    public static Map<String, Object> getLoginWithMissingField(String fieldToRemove) {
        Map<String, Object> loginData = getValidLoginPayload();
        loginData.remove(fieldToRemove);
        return loginData;
    }

    public static Map<String, Object> getLoginWithPartialGeo() {
        Map<String, Object> loginData = getValidLoginPayload();
        Map<String, Object> partialGeo = new HashMap<>();
        partialGeo.put("ipAddress", "192.168.1.1"); // partial geoData
        loginData.put("geoData", partialGeo);
        return loginData;
    }

    public static Map<String, Object> getLoginWithExtraField() {
        Map<String, Object> loginData = getValidLoginPayload();
        loginData.put("browser", "Chrome"); // extra field
        return loginData;
    }

    public static Map<String, Object> getLoginWithInvalidTimeZone() {
        Map<String, Object> loginData = getValidLoginPayload();
        loginData.put("timeZone", "invalid/timezone");
        return loginData;
    }

    public static Map<String, Object> getBlankRequestBody() {
        return new HashMap<>();
    }
}
