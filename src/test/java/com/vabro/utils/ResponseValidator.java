package com.vabro.utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseValidator {

    // === Boolean Checks (Soft or Logging Use) ===
    // Validates if the response has a successful status code (200-299)
    public static boolean isStatusCodeValid(Response response) {
        int statusCode = response.getStatusCode();
        return statusCode >= 200 && statusCode < 300;
    }

    // Validates if the response contains a specific string
    public static boolean doesResponseContain(Response response, String expectedValue) {
        return response.getBody().asString().contains(expectedValue);
    }

    // Validates if the response has a specific status code
    public static boolean isStatusCode(Response response, int expectedStatusCode) {
        return response.getStatusCode() == expectedStatusCode;
    }

    // === Assert-Based Validation (for TestNG Assertions) ===
    public static void validateSuccess(Response response) {
        Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK");
    }

    public static void validateFieldNotEmpty(Response response, String field) {
        Assert.assertNotNull(response.jsonPath().get(field), "Field '" + field + "' should not be null");
    }

    public static void validateContains(Response response, String expectedText) {
        Assert.assertTrue(response.getBody().asString().contains(expectedText),
                "Response does not contain expected text: " + expectedText);
    }
}

