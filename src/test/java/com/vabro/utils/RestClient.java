package com.vabro.utils;

import config.AppConfig;
import io.restassured.RestAssured;
import io.restassured.config.DecoderConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import static config.AppConfig.BASE_URL;

public class RestClient {
   // private static Properties properties = new Properties();

    // Use the BASE_URL and AUTH_TOKEN from AppConfig
    public static Response sendGetRequest(String endpoint) {
        RequestSpecification request = RestAssured.given()
                .baseUri(AppConfig.BASE_URL)  // Set the base URI from AppConfig
                .contentType(AppConfig.CONTENT_TYPE); // Default content type

        return request.get(endpoint);
    }

    // Send a POST request
    public static Response sendPostRequest(String endpoint, String body) {
        RestAssured.config = RestAssured.config()
                .decoderConfig(DecoderConfig.decoderConfig().noContentDecoders());

        RequestSpecification request = RestAssured.given()
                .baseUri(AppConfig.BASE_URL)  // Set the base URI from AppConfig
                .contentType(AppConfig.CONTENT_TYPE)
                .body(body);  // Add the body if required

        return request.post(endpoint);
    }
    // Send a POST request
    public static Response sendPostRequestWithToken(String endpoint, String body) {

        String token = TokenManager.getToken();

        //String bearerToken = AppConfig.getBearerToken();
        RestAssuredUtils.configureRestAssured(); // Apply config once here

        RequestSpecification request = RestAssured.given()
                .baseUri(AppConfig.BASE_URL)  // Set the base URI from AppConfig
                .contentType(AppConfig.CONTENT_TYPE)
                .header("Authorization", "Bearer " + token)
                .body(body);  // Add the body if required

        return request.post(endpoint);
    }

    // Generic method to send POST request with custom headers
    public static Response sendPostRequestWithHeaders(String endpoint, String body, Map<String, String> headers) {
        // Create a RequestSpecification object
        RequestSpecification request = io.restassured.RestAssured.given()
                .baseUri(AppConfig.BASE_URL)          // Set the base URL
                .contentType(AppConfig.CONTENT_TYPE) // Set the content type to JSON
                .body(body); // Set the request body (converted to JSON)

        // Add custom headers to the request
        for (Map.Entry<String, String> header : headers.entrySet()) {
            request.header(header.getKey(), header.getValue());
        }

        // Send POST request and return the response
        return request.post(endpoint);
    }

    // Send a GET request with Authorization (for example, after login)
    public static Response sendGetRequestWithToken(String endpoint) {
        // Send GET request with Authorization header using the token from AppConfig
        RequestSpecification request = RestAssured.given()
                .baseUri(AppConfig.BASE_URL)  // Set the base URI from AppConfig
                .contentType(AppConfig.CONTENT_TYPE)
                .header("Authorization", "Bearer " + AppConfig.AUTH_TOKEN);  // Authorization header using the token

        return request.get(endpoint);
    }

    // Send a PUT request (for updating a resource)
    public static Response sendPutRequest(String endpoint, String body) {
        RequestSpecification request = RestAssured.given()
                .baseUri(AppConfig.BASE_URL)  // Set the base URL from AppConfig
                .contentType(AppConfig.CONTENT_TYPE)
                .body(body);  // The body of the PUT request (usually JSON data)

        return request.put(endpoint);  // Send the PUT request to the endpoint
    }

    // Send a DELETE request (for deleting a resource)
    public static Response sendDeleteRequest(String endpoint) {
        RequestSpecification request = RestAssured.given()
                .baseUri(AppConfig.BASE_URL)  // Set the base URL from AppConfig
                .contentType(AppConfig.CONTENT_TYPE);


        return request.delete(endpoint);  // Send the DELETE request to the endpoint
    }

    // Send a GET request with query parameters
    public static Response sendGetRequestWithParam(String endpoint, Map<String, String> queryParams) {
        RequestSpecification request = RestAssured.given()
                .baseUri(AppConfig.BASE_URL)  // Set the base URL from AppConfig
                .contentType(AppConfig.CONTENT_TYPE)
                .header("Authorization", "Bearer " + AppConfig.AUTH_TOKEN);

        // Add query parameters to the request
        if (queryParams != null && !queryParams.isEmpty()) {
            request.params(queryParams);  // Add query parameters to the request
        }

        return request.get(endpoint);  // Send the GET request with parameters
    }
    // Send a GET request with query parameters
    public static Response sendGetRequestWithParams(String endpoint, Map<String, List<String>> queryParams) {
        RequestSpecification request = RestAssured.given()
                .baseUri(AppConfig.BASE_URL)  // Set the base URL from AppConfig
                .contentType(AppConfig.CONTENT_TYPE)
                .header("Authorization", "Bearer " + AppConfig.AUTH_TOKEN);

        // Properly add multi-value query parameters
        if (queryParams != null && !queryParams.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : queryParams.entrySet()) {
                for (String value : entry.getValue()) {
                    request.queryParam(entry.getKey(), value);
                }
            }
        }

        return request.get(endpoint);  // Send the GET request with parameters
    }
    public static Response sendGetRequestWithParams(String endpoint, String qParams) {
        RequestSpecification request = RestAssured.given()
                .baseUri(AppConfig.BASE_URL)  // Set the base URL from AppConfig
                .contentType(AppConfig.CONTENT_TYPE)
                .header("Authorization", "Bearer " + AppConfig.AUTH_TOKEN);

        // Add query parameters to the request
        if (qParams != null && !qParams.isEmpty()) {
           // Add query parameters to the request
            request.param(qParams);
        }

        return request.get(endpoint);
    }

    public static Response sendOptionsRequest(String endpoint) {
        return RestAssured.given()
                .baseUri(AppConfig.BASE_URL)
                .contentType(AppConfig.CONTENT_TYPE)
                .when()
                .options(endpoint);
    }

}

