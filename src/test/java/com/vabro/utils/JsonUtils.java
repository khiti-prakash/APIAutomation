package com.vabro.utils;



import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class JsonUtils {

    // Method to serialize a Java object to JSON string
    public static String toJson(Object object) {
        Gson gson = new Gson();  // Create Gson object
        String jsonStringPayLoad = gson.toJson(object);
        return  jsonStringPayLoad; // Convert object to JSON string

//        try {
//            Gson gson = new Gson();
//            return gson.toJson(object);
//        } catch (JsonParseException e) {
//            System.err.println("Error during JSON serialization: " + e.getMessage());
//            e.printStackTrace();
//            return null;  // Or handle it as per your use case
//        }
    }

    // Method to deserialize JSON string to a Java object
    public static <T> T fromJson(String json, Class<T> clazz) {
        Gson gson = new Gson();  // Create Gson object
        try {
            return gson.fromJson(json, clazz);  // Convert JSON string to object
        } catch (JsonSyntaxException e) {
            throw new RuntimeException("Failed to convert JSON to object", e);  // Handle errors
        }
    }
}
