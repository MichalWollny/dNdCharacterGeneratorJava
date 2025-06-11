package main.java.com.myproject.dndcharactergenerator.backend.utilities;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static main.java.com.myproject.dndcharactergenerator.backend.utilities.UtilityMethods.confirmationChoice;

public class DiceRolls {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public enum Dices {
        D4,
        D6,
        D8,
        D10,
        D12,
        D20
    }

    public static boolean diceRolling() {
        String diceChoice;
        int rollAmount;
        boolean running = true;
        while (running) {

            diceChoice = readInputString();
            rollAmount = readInputInt();

            diceRoller(diceChoice, rollAmount);

            String prompt = "\nDo you wish to roll again?";
            running = confirmationChoice(prompt);
        }
        return true;
    }

    private static String readInputString() {
        while (true) {
            System.out.println("Which dice would you like to roll?\n(Choose from: D4, D6, D8, D10, D12, D20");
            String text = scanner.nextLine().toUpperCase();

            try {
                Dices.valueOf(Dices.class, text);
                return text;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid dice type.");
            }
        }
    }

    private static int readInputInt() {
        while (true) {
            System.out.println("How many times will you roll the dice?");
            try {
                int diceRolled = scanner.nextInt();
                scanner.nextLine();

                if (diceRolled > 0) {
                    return diceRolled;
                }
                else {
                    System.out.println("The number must be positive! Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error! Invalid input. Please enter a valid, positive integer!");
                scanner.next();
            }
        }
    }

    private static void diceRoller(String diceChoice, int rollAmount) {
        int totalRollValue = 0;

        System.out.print("Rolling " + rollAmount + "x " + diceChoice + ": ");
        for (int i = 0; i < rollAmount; i++) {
            int currentRoll = 0;
            switch (diceChoice) {
                case "D4":
                    currentRoll = random.nextInt(1, 5);
                    break;
                case "D6":
                    currentRoll = random.nextInt(1, 7);
                    break;
                case "D8":
                    currentRoll = random.nextInt(1, 9);
                    break;
                case "D10":
                    currentRoll = random.nextInt(1, 11);
                    break;
                case "D12":
                    currentRoll = random.nextInt(1, 13);
                    break;
                case "D20":
                    currentRoll = random.nextInt(1, 21);
                    if (currentRoll == 1) {
                        System.out.print(" (Crit Fail!) ");
                    }
                    else if (currentRoll == 20) {
                        System.out.print(" (NAT20!) ");
                    }
                    break;
                default:
                    System.out.println("Internal Error: Invalid dice type for rolling.");
                    return;
            }
            totalRollValue += currentRoll;
            System.out.print(currentRoll + (i < rollAmount - 1 ? " + " : "")); // Print rolls inline
        }
        System.out.println("\nTotal Roll Value is " + totalRollValue);
    }

    public static int statRolls() {
        int[] rolls = new int[4];

        for (int i = 0; i < 4; i++) {
            int d6 = random.nextInt(1, 7);
            rolls[i] = d6;
        }
        Arrays.sort(rolls);
        rolls[0] = 0;
        int rollsSum = 0;
        for (int j = 0; j < 4; j++) {
            rollsSum += rolls[j];
        }
        // or int rollsSum = rolls[1] + rolls[2] + rolls[3];
        return rollsSum;
    }

}
