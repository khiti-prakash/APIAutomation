package com.vabro.data;

    public class ApiTestData {

        // Predefined user data for testing purposes
        public static final String VALID_USER_JSON = "{\n" +
                "  \"name\": \"John Doe\",\n" +
                "  \"email\": \"john.doe@example.com\",\n" +
                "  \"password\": \"securePassword123\"\n" +
                "}";

        public static final String INVALID_USER_JSON = "{\n" +
                "  \"name\": \"\",\n" +
                "  \"email\": \"invalid-email\",\n" +
                "  \"password\": \"\"\n" +
                "}";

        // Predefined booking data
        public static final String VALID_BOOKING_JSON = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"bookingId\": \"BK1234\",\n" +
                "  \"date\": \"2025-02-01\",\n" +
                "  \"location\": \"New York\"\n" +
                "}";

        public static final String INVALID_BOOKING_JSON = "{\n" +
                "  \"userId\": -1,\n" +
                "  \"bookingId\": \"\",\n" +
                "  \"date\": \"\",\n" +
                "  \"location\": \"\"\n" +
                "}";

        // Expected response data (for validation)
        public static final String EXPECTED_USER_RESPONSE = "{\n" +
                "  \"status\": \"success\",\n" +
                "  \"message\": \"User created successfully.\"\n" +
                "}";

        public static final String EXPECTED_BOOKING_RESPONSE = "{\n" +
                "  \"status\": \"success\",\n" +
                "  \"message\": \"Booking created successfully.\"\n" +
                "}";

        // Sample authentication data
        public static final String VALID_AUTH_JSON = "{\n" +
                "  \"username\": \"john.doe\",\n" +
                "  \"password\": \"securePassword123\"\n" +
                "}";

        public static final String INVALID_AUTH_JSON = "{\n" +
                "  \"username\": \"\",\n" +
                "  \"password\": \"wrongPassword\"\n" +
                "}";
    }


