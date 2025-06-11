package main.java.com.myproject.dndcharactergenerator.backend;

import java.util.Scanner;

import static main.java.com.myproject.dndcharactergenerator.backend.utilities.DiceRolls.statRolls;
import static main.java.com.myproject.dndcharactergenerator.backend.utilities.UtilityMethods.confirmationChoice;

public class CharacterGenerator {
    static Scanner scanner = new Scanner(System.in);

    // DEFINING THE CHARACTER CLASS

    static class Character {
        private String characterName;
        // private String characterClass;
        // private String characterRace;
        private CharacterAttributes charAttributes;


        public Character(String characterName, CharacterAttributes charAttributes) {
            this.characterName = characterName;
            // this.characterClass = characterClass;
            // this.characterRace = characterRace;
            this.charAttributes = charAttributes;
        }

        public void displayInfo() {
            System.out.println("Character Name: " + characterName);
            // System.out.println("Character Class: " + characterClass);
            // System.out.println("Character Race: " + characterRace);
            charAttributes.displayCharacterAttributes();
        }
    }

    // CUSTOM METHODS

    public static boolean customCharacter() {
        boolean running = false;
        while (!running) {

            System.out.println("\n--- Starting New Character Creation ---");

            System.out.println("\nStep 1: Character Name");
            String name = readCharacterName();

            System.out.println("\nStep 2: Character Attributes");
            CharacterAttributes attributes = attributesCustom();

            System.out.println("\nStep 3: Putting it all together...");
            Character newCharakter = new Character(name, attributes);
            newCharakter.displayInfo();

            //System.out.println("Do you wish to save the character or start from scratch? Y/N");

            String prompt = "Do you wish to exit to last menu?";
            running = confirmationChoice(prompt);
        }
        return true;
    }

    public static CharacterAttributes attributesCustom() {
        boolean running = true;
        CharacterAttributes chosenAttributes = null;

        while (running) {

            System.out.println("\nRolling attributes...\n");

            int str = statRolls();
            int dex = statRolls();
            int con = statRolls();
            int intel = statRolls();
            int wis = statRolls();
            int cha = statRolls();

            CharacterAttributes currentRolls = new CharacterAttributes(str, dex, con, intel, wis, cha);
            currentRolls.displayCharacterAttributes();

            String prompt = "Do you wish to confirm the attributes (Y) or roll again(N)?";
            boolean choice = confirmationChoice(prompt);
            if (choice){
                chosenAttributes = currentRolls;
                running = false;
            }
            if (!choice){
                System.out.println("Discarding current attributes. Rolling again...\n");
            }
        }
        return chosenAttributes;
    }


    // RANDOM METHODS

    public static boolean randomCharacter() {
        boolean running = true;
        while (running) {
            String name = readCharacterName();
            System.out.println("\nRolling attributes...\n");

            Character randomCharacter = new Character(name, randomAttributes());
            System.out.println("Okay... this is what the dice dictate:");

            randomCharacter.displayInfo();

            String prompt = "Do you want to generate another character?";
            running = confirmationChoice(prompt);
        }
        return true;
    }

    public static CharacterAttributes randomAttributes() {
        int str = statRolls();
        int dex = statRolls();
        int con = statRolls();
        int intel = statRolls();
        int wis = statRolls();
        int cha = statRolls();

        return new CharacterAttributes(str, dex, con, intel, wis, cha);

    }

    // NAMING THE CHARACTER

    public static String readCharacterName() {
        boolean confirm = false;
        String name = "";

        while (!confirm) {
            System.out.println("What is the characters name?");
            name = scanner.nextLine();

            if (name.trim().isEmpty()) {
                System.out.println("Character Name cannot be empty! Please enter a valid character name!");
                continue;
            }

            System.out.println("Please confirm - character name:\n" + name + "\nY/N");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty! Please enter a valid choice!");
                continue;
            }

            char inputChar = java.lang.Character.toUpperCase(input.charAt(0));

            if (inputChar == 'Y') {
                confirm = true;
            }
            if (inputChar == 'N') {
                System.out.println("Ok, please enter another name!\n");
            }
        }
        return name;
    }
}
