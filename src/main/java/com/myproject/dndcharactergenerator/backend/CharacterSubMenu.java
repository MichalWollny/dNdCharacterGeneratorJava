package main.java.com.myproject.dndcharactergenerator.backend;

import java.util.Scanner;

import static main.java.com.myproject.dndcharactergenerator.backend.MainMenu.readMenuInputInt;
import static main.java.com.myproject.dndcharactergenerator.backend.CharacterGenerator.randomCharacter;
import static main.java.com.myproject.dndcharactergenerator.backend.CharacterGenerator.customCharacter;

public class CharacterSubMenu {

    static Scanner scanner = new Scanner(System.in);

    public static boolean characterSubMenu(){
        boolean running = true;

        do {
            characterSubMenuOptions();
            int menuChoice = readMenuInputInt(2);
            switch (menuChoice) {
                case 1:
                    System.out.println("\n--- Generating a Random Character ---\n");
                    running = randomCharacter();
                    break;
                case 2:
                    System.out.println("\n--- Generating a Custom Character ---\n");
                    running = customCharacter();
                    break;
                case 0:
                    System.out.println("\nExiting Character Menu.\n");
                    running = false;
                    break;
            }
        } while (running);
        return true;
    }

    private static void characterSubMenuOptions() {
        System.out.println("\n--- Creating New Character ---\n");
        System.out.println("Please choose from the following:");
        System.out.println("\n1. Generate a Random Character");
        System.out.println("(Stats, Class and Race will be assigned randomly)");
        System.out.println("2. Generate a Custom Character");
        System.out.println("(You will be prompted to make the Choices)");
        System.out.println("0. Back to the Main Menu");
    }


}
