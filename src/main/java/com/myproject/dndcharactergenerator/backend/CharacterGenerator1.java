package main.java.com.myproject.dndcharactergenerator.backend;

import java.util.Random;
import java.util.Scanner;

public class CharacterGenerator1 {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static String readCharacterName() {
        try {
            System.out.println("What is the characters name?");
            String text = scanner.nextLine();
            return text;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please enter a valid dice type.");
            return readCharacterName();
        }
    }

    static class Character{
            private String characterName;
            private String characterClass;
            private String characterRace;
            private CharacterAttributes charAttributes;



            public Character(String characterName, String characterClass, String characterRace, CharacterAttributes charAttributes){
                this.characterName = characterName;
                this.characterClass = characterClass;
                this.characterRace = characterRace;
                this.charAttributes = charAttributes;
            }

            public void displayInfo(){
                System.out.println("Character Name: " + characterName);
                System.out.println("Character Class: " + characterClass);
                System.out.println("Character Race: " + characterRace);
                charAttributes.displayCharacterAttributes();
            }
        }

    public static void generateCharacter(){
        String name = scanner.nextLine();
        String charClass = readCharClass();
        String race = scanner.nextLine();
        CharacterAttributes attributes = new CharacterAttributes(10, 15, 12, 14, 13, 8);

        Character character = new Character(name, charClass, race, attributes);
        character.displayInfo();

    }

    public static String readCharClass(){
        try {
            System.out.println("Input character class:");
            String text = scanner.nextLine();
            Enum.valueOf(CharacterClass.AvailableClasses.class, text.toUpperCase());
            return text;
        } catch (IllegalArgumentException e){
            System.out.println("No such character class! Try again!");
            return readCharClass();
        }

    }

    /*
    public static void main(String[] args) {




        // CharacterAttributes attributes = new CharacterAttributes(10, 15, 12, 14, 13, 8);
        // Character character = new CharacterGenerator().new Character("Aragorn", "Ranger", "Human", attributes);
        // character.displayInfo();
    }
     */
}
