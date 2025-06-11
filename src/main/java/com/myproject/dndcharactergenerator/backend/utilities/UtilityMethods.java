package main.java.com.myproject.dndcharactergenerator.backend.utilities;

import java.util.Scanner;

public class UtilityMethods {
    static Scanner scanner = new Scanner(System.in);

    // REUSABLE CONFIRMATION METHODS
    public static boolean confirmationChoice(String prompt) {
        while (true) { // Loop indefinitely until valid Y/N input is received
            System.out.print(prompt + " (Y/N): ");
            String inputLine = scanner.nextLine().trim();

            if (inputLine.isEmpty()) {
                System.out.println("No input detected. Please enter 'Y' or 'N'.");
                continue; // Go to next loop iteration
            }

            char choice = Character.toUpperCase(inputLine.charAt(0));

            if (choice == 'Y') {
                return true; // User confirmed 'Yes'
            }
            else if (choice == 'N') {
                return false; // User confirmed 'No'
            }
            else {
                System.out.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
            }
        }

    }
}
