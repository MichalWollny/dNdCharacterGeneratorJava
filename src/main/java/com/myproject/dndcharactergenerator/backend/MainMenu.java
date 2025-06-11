package main.java.com.myproject.dndcharactergenerator.backend;

import java.util.InputMismatchException;
import java.util.Scanner;

import static main.java.com.myproject.dndcharactergenerator.backend.CharacterSubMenu.characterSubMenu;
import static  main.java.com.myproject.dndcharactergenerator.backend.utilities.DiceRolls.diceRolling;

public class MainMenu {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        do {
            mainMenu();
            int menuChoice = readMenuInputInt(5);
            switch (menuChoice) {
                case 1:
                    running = characterSubMenu();
                    break;
                case 2:
                    System.out.println("\n--- Loading Existing Character ---");
                    // Call a method for loading a character
                    // loadCharacter();
                    break;
                case 3:
                    System.out.println("\n--- Viewing Character List ---");
                    // Call a method for viewing characters
                    // viewCharacterList();
                    break;
                case 4:
                    System.out.println("\n--- Let's roll some dice! ---");
                    running = diceRolling();
                    break;
                case 0:
                    System.out.println("\nExiting D&D Character Generator. Goodbye!");
                    running = false;
                    break;
            }

        } while (running);
    }

    public static void mainMenu() {
        System.out.println("\n--- D&D Character Generator Menu ---\n");
        System.out.println("Please choose how to proceed:");
        System.out.println("1. Create New Character");
        System.out.println("2. Load Existing Character");
        System.out.println("3. View Character List");
        System.out.println("4. Roll some dices");
        System.out.println("0. Exit Application");
        System.out.print("\nEnter your choice: ");
    }


    public static int readMenuInputInt(int menuLength) {
        boolean validInput = false;
        int inputInt = -1;
        while (!validInput) {
            try {
                inputInt = scanner.nextInt();
                scanner.nextLine();

                if (inputInt >= 0 && inputInt <= menuLength) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and " + menuLength + ".");
                    System.out.println("Enter your choice: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number, it must be between 0 and " + menuLength +
                        ".");
                scanner.nextLine();
                System.out.println("Enter your choice: ");
            }
        }
        return inputInt;
    }

}
