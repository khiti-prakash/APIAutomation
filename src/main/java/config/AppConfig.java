package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {

    private static Properties properties = new Properties();
    private static String configFilePath;

    // Load config based on environment: "dev", "prod", etc.
    public static void load(String environment) {
        try{
        configFilePath = System.getProperty("user.dir") +"/src/main/java/com/vabro/resources/config-" + environment + ".properties";
         FileInputStream inputStream = new FileInputStream(configFilePath);
            properties.load(inputStream);
            System.out.println("Loaded config for: " + environment);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file for: " + environment, e);
        }
    }

    // Generic access
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Specific getters
    public static String getBearerToken() {
        return getProperty("bearer.token");
    }

    public static String getRefreshToken() {
        return getProperty("refresh.token");
    }

    public static String getBaseUrl() {
        return getProperty("api.base.url");
    }

    public static String getEmail() {
        return System.getProperty("emailId", properties.getProperty("api.emailId"));
    }

    public static String getPassword() {
        return System.getProperty("password", properties.getProperty("api.password"));
    }

    // Token Updaters
    public static void updateBearerToken(String token) {
        properties.setProperty("bearer.token", token);
        saveConfig();
    }

    public static void updateRefreshToken(String refreshToken) {
        properties.setProperty("refresh.token", refreshToken);
        saveConfig();
    }

    public static String getContentType() {
        return getProperty("content.type");
    }

    // Save to config file
    private static void saveConfig() {
        try (FileOutputStream outputStream = new FileOutputStream(configFilePath)) {
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to save config: " + e.getMessage());
        }
    }
}