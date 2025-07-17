package com.vabro.utils;

import java.util.Base64;
import java.util.Date;
import org.json.JSONObject;
public class JwtUtils {

        // Decode JWT and check if expired
        public static boolean isTokenExpired(String token) {
            try {
                String[] parts = token.split("\\.");
                if (parts.length < 2) return true;

                String payloadJson = new String(Base64.getUrlDecoder().decode(parts[1]));
                JSONObject payload = new JSONObject(payloadJson);

                long exp = payload.getLong("exp");  // expiry time in seconds
                long now = System.currentTimeMillis() / 1000;

                return now >= exp;
            } catch (Exception e) {
                e.printStackTrace();
                return true; // Treat token as expired if error
            }
        }

    // Extract user ID or email from token
    public static String getUserIdFromToken(String token) {
        try {
            String[] parts = token.split("\\.");
            if (parts.length < 2) return null;

            String payloadJson = new String(Base64.getUrlDecoder().decode(parts[1]));
            JSONObject payload = new JSONObject(payloadJson);

            // This depends on what your JWT payload contains.
            // Replace with actual key if needed
            return payload.optString("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/nameidentifier", null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    }


