package com.vabro.data;

import java.util.HashMap;
import java.util.Map;

public class VabroRefreshTokenTestData {

    public static Map<String, Object> getValidRefreshPayload(String refreshToken) {
        Map<String, Object> map = new HashMap<>();
        map.put("refreshToken", refreshToken);
        map.put("ipAddress", "192.168.1.1");
        map.put("deviceType", "Desktop");
        return map;
    }

    public static Map<String, Object> getMissingFieldPayload(String field) {
        Map<String, Object> map = getValidRefreshPayload("dummy");
        map.remove(field);
        return map;
    }

    public static Map<String, Object> getBlankPayload() {
        return new HashMap<>();
    }
}
