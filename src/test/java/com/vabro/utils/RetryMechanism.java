package com.vabro.utils;

import io.restassured.response.Response;
import java.util.concurrent.TimeUnit;

public class RetryMechanism {

    private static final int MAX_RETRIES = 3;  // Maximum number of retries
    private static final long RETRY_DELAY = 2000;  // Delay between retries in milliseconds

    // Retry mechanism for sending API requests
    public static Response sendRequestWithRetry(String endpoint, String method, String body) {
        int attempts = 0;
        while (attempts < MAX_RETRIES) {
            try {
                attempts++;
                Response response;
                // Send the request depending on the HTTP method
                switch (method.toUpperCase()) {
                    case "GET":
                        response = RestClient.sendGetRequest(endpoint);
                        break;
                    case "POST":
                        response = RestClient.sendPostRequest(endpoint, body);
                        break;
                    case "PUT":
                        response = RestClient.sendPutRequest(endpoint, body);
                        break;
                    case "DELETE":
                        response = RestClient.sendDeleteRequest(endpoint);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid HTTP method: " + method);
                }

                // If the request was successful, return the response
                if (ResponseValidator.isStatusCodeValid(response)) {
                    return response;
                }

                // Wait before retrying
                TimeUnit.MILLISECONDS.sleep(RETRY_DELAY);
            } catch (Exception e) {
                if (attempts >= MAX_RETRIES) {
                    throw new RuntimeException("Request failed after retries", e);
                }
            }
        }
        throw new RuntimeException("Request failed after maximum retries");
    }
}
