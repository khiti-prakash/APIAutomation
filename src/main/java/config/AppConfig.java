package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {

    private static final String CONFIG_FILE_PATH = "E:/Java Folder/APIAutomation/src/main/java/com/vabro/resources/config.properties";
    private static Properties properties = new Properties();

    // Load properties from the config.properties file
    static {
        try {
            FileInputStream inputStream = new FileInputStream(CONFIG_FILE_PATH); // Update with your correct path
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to update the token in the properties file
    public static void updateBearerToken(String token) {
        //Properties properties = new Properties();
        try {
            // Load the properties file using FileInputStream
            FileInputStream inputStream = new FileInputStream(CONFIG_FILE_PATH);
            properties.load(inputStream);

            // Update the auth token
            properties.setProperty("bearer.token", token);


            // Save the updated properties back to the config file
            try (FileOutputStream outputStream = new FileOutputStream(CONFIG_FILE_PATH)) {
                properties.store(outputStream, null); // Save the updated properties to the file
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error updating the config file: " + e.getMessage());
        }
    }
    public static String getBearerToken() {
        try (FileInputStream inputStream = new FileInputStream(CONFIG_FILE_PATH)) {
            Properties props = new Properties();
            props.load(inputStream);
            return props.getProperty("bearer.token");
        } catch (IOException e) {
            throw new RuntimeException("Error reading bearer token from config file", e);
        }
    }
    public static String getRefreshToken() {
        try (FileInputStream inputStream = new FileInputStream(CONFIG_FILE_PATH)) {
            Properties props = new Properties();
            props.load(inputStream);
            return props.getProperty("refresh.token");
        } catch (IOException e) {
            throw new RuntimeException("Error reading refresh token from config file", e);
        }
    }
    public static void updateRefreshToken(String refreshToken) {
        try {
            // Load existing properties
            FileInputStream inputStream = new FileInputStream(CONFIG_FILE_PATH);
            properties.load(inputStream);

            // Set only refresh token
            properties.setProperty("refresh.token", refreshToken);

            // Save to config file
            try (FileOutputStream outputStream = new FileOutputStream(CONFIG_FILE_PATH)) {
                properties.store(outputStream, null);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error updating refresh token in config file: " + e.getMessage());
        }
    }
    public static final String EMAIL_ID = System.getProperty("emailId", properties.getProperty("api.emailId"));
    public static final String PASSWORD = System.getProperty("password", properties.getProperty("api.password"));

    // Load the base URL and token from the properties file
    public static final String BASE_URL = properties.getProperty("api.base.url");
    public static final String AUTH_TOKEN = properties.getProperty("bearer.token");

    // Optionally, add any default headers or other configuration if needed
    public static final String CONTENT_TYPE = "application/json"; // Default content type, can also be set dynamically
}
