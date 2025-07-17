package com.vabro.data;

import java.util.Random;

public class TestDataGenerator {

    private static final String[] NAMES = {"John", "Jane", "Alice", "Bob", "Charlie"};
    private static final String[] EMAILS = {"john.doe@example.com", "jane.doe@example.com", "alice.smith@example.com", "bob.brown@example.com", "charlie.jones@example.com"};

    // Generate a random user name from predefined list
    public static String generateRandomName() {
        Random random = new Random();
        return NAMES[random.nextInt(NAMES.length)];
    }

    // Generate a random email from predefined list
    public static String generateRandomEmail() {
        Random random = new Random();
        return EMAILS[random.nextInt(EMAILS.length)];
    }

    // Generate random password (e.g., 8-12 characters)
    public static String generateRandomPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }

    // Generate a random user ID (integer between 1 and 1000)
    public static int generateRandomUserId() {
        Random random = new Random();
        return random.nextInt(1000) + 1;
    }

    // Generate a random booking ID (e.g., "BK1234")
    public static String generateRandomBookingId() {
        return "BK" + (1000 + new Random().nextInt(9000)); // Generates booking ID like BK1234
    }

    // Example of generating complete user data for a POST request
    public static String generateUserData() {
        return "{\n" +
                "  \"name\": \"" + generateRandomName() + "\",\n" +
                "  \"email\": \"" + generateRandomEmail() + "\",\n" +
                "  \"password\": \"" + generateRandomPassword() + "\"\n" +
                "}";
    }

    // Example of generating booking data for a POST request
    public static String generateBookingData() {
        return "{\n" +
                "  \"userId\": " + generateRandomUserId() + ",\n" +
                "  \"bookingId\": \"" + generateRandomBookingId() + "\",\n" +
                "  \"date\": \"2025-02-01\",\n" +
                "  \"location\": \"New York\"\n" +
                "}";
    }
}

