package com.vabro.data;

import config.AppConfig;

import java.util.HashMap;
import java.util.Map;

public class VabroAutoLoginTestData {
   static String token = AppConfig.getBearerToken();
    public static Map<String, Object> getValidAutoLoginPayload() {
        Map<String, Object> geoData = new HashMap<>();
        geoData.put("ipAddress", "192.168.1.1");
        geoData.put("country", "India");
        geoData.put("state", "Odisha");
        geoData.put("city", "Bhubaneswar");
        geoData.put("timeZone", "Asia/Kolkata");

        Map<String, Object> payload = new HashMap<>();
        payload.put("emailId", "testervabro1@gmail.com");
        payload.put("firstName", "Test");
        payload.put("lastName", "User");
        payload.put("token", token); // Replace with a valid one if required
        payload.put("ipAddress", "192.168.1.1");
        payload.put("deviceType", "Desktop");
        payload.put("geoData", geoData);
        payload.put("language", "en");

        return payload;
    }

    public static Map<String, Object> getPayloadWithMissingField(String field) {
        Map<String, Object> payload = getValidAutoLoginPayload();
        payload.remove(field);
        return payload;
    }

    public static Map<String, Object> getPayloadWithBlankToken() {
        Map<String, Object> payload = getValidAutoLoginPayload();
        payload.put("token", "");
        return payload;
    }

    public static Map<String, Object> getPayloadWithInvalidToken() {
        Map<String, Object> payload = getValidAutoLoginPayload();
        payload.put("token", "invalid.token.here");
        return payload;
    }

    public static Map<String, Object> getPayloadWithExtraFields() {
        Map<String, Object> payload = getValidAutoLoginPayload();
        payload.put("extraField", "extraValue");
        return payload;
    }

    public static Map<String, Object> getEmptyRequestBody() {
        return new HashMap<>();
    }
}
