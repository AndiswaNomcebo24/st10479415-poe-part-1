
package com.mycompany.main;

import java.util.Scanner;

public class Main {

    // Creates Scanner for user input
    static Scanner input = new Scanner(System.in);

    // Stores the user's entered details
    static String username;
    static String password;
    static String cellphone;

    // Stores the registered details
    static String registeredUsername;
    static String registeredPassword;
    static String registeredCellphone;

    // Checks whether the username is correctly formatted
    public static boolean checkUserName(String username) {
        // Username must have exactly 5 characters
        // and must contain an underscore
        return username.length() == 5 && username.contains("_");
    }

    // Checks whether the password meets the complexity requirements
    public static boolean checkPasswordComplexity(String password) {
        // Password must have at least 8 characters
        // and contain uppercase, lowercase, number and special character
        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[^a-zA-Z0-9].*");
    }

    // Checks whether the cellphone number is correctly formatted
    public static boolean checkCellphoneNumber(String number) {
        // Number must start with +27 followed by exactly 9 digits
        return number.matches("^\\+27[0-9]{9}$");
    }

    // Handles the registration process
    public static void registerUser() {

        // Get a valid username
        while (true) {
            System.out.print("Enter your username: ");
            username = input.nextLine();

            if (checkUserName(username)) {
                break;
            } else {
                System.out.println(
                    "Username is incorrectly formatted. Please try again."
                );
            }
        }

        // Get a valid password
        while (true) {
            System.out.print("Enter your password: ");
            password = input.nextLine();

            if (checkPasswordComplexity(password)) {
                break;
            } else {
                System.out.println(
                    "Password is incorrectly formatted. Please try again."
                );
            }
        }

        // Get a valid cellphone number
        while (true) {
            System.out.print("Enter your cellphone number (+27): ");
            cellphone = input.nextLine();

            if (checkCellphoneNumber(cellphone)) {
                break;
            } else {
                System.out.println(
                    "Cellphone number is incorrectly formatted. Please try again."
                );
            }
        }

        // Save the valid registration details
        registeredUsername = username;
        registeredPassword = password;
        registeredCellphone = cellphone;

        System.out.println("User registered successfully.");
    }

    // Checks the login details
    public static boolean loginUser(String username, String password) {

        // Compare entered details with registered details
        return username.equals(registeredUsername)
                && password.equals(registeredPassword);
    }

    // Returns the login status message
    public static String returnLoginStatus(boolean loginSuccessful) {

        if (loginSuccessful) {
            return "Welcome, it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Main method where the program starts
    public static void main(String[] args) {

        // Registration
        registerUser();

        // Login
        System.out.println("\nPlease log in.");

        System.out.print("Enter your username to login: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter your password to login: ");
        String loginPassword = input.nextLine();

        // Check login
        boolean loginSuccessful = loginUser(
                loginUsername,
                loginPassword
        );

        // Display login status
        System.out.println(returnLoginStatus(loginSuccessful));
    }
}
