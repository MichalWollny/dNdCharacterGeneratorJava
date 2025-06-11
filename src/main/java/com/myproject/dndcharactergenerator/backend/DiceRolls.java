package main.java.com.myproject.dndcharactergenerator.backend;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DiceRolls {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    enum Dices {
        D4,
        D6,
        D8,
        D10,
        D12,
        D20
    }

    public static void main(String[] args) {
        String diceChoice;
        int rollAmount;

        diceChoice = readInputString();
        rollAmount = readInputInt();

        diceRoller(diceChoice, rollAmount);
    }

    private static String readInputString() {
        try {
            System.out.println("Which dice would you like to roll?\n(Choose from: D4, D6, D8, D10, D12, D20");
            String text = scanner.nextLine().toUpperCase();
            Enum.valueOf(Dices.class, text);
            return text;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please enter a valid dice type.");
            return readInputString();
        }
    }

    private static int readInputInt() {
        while (true) {
            System.out.println("How many times will you roll the dice?");
            try {
                int diceRolled = scanner.nextInt();
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
        switch (diceChoice) {
            case "D4":
                for (int i = 0; i < rollAmount; i++) {
                    int d4 = random.nextInt(1, 5);
                    totalRollValue += d4;
                    if (i == 0) {
                        System.out.println(d4);
                    }
                    else {
                        System.out.println(" + " + d4);
                    }
                }
                System.out.println("Total Roll Value is " + totalRollValue);
                break;
            case "D6":
                for (int i = 0; i < rollAmount; i++) {
                    int d6 = random.nextInt(1, 7);
                    totalRollValue += d6;
                    if (i == 0) {
                        System.out.println(d6);
                    }
                    else {
                        System.out.println(" + " + d6);
                    }
                }
                System.out.println("Total Roll Value is " + totalRollValue);
                break;
            case "D8":
                for (int i = 0; i < rollAmount; i++) {
                    int d8 = random.nextInt(1, 9);
                    totalRollValue += d8;
                    if (i == 0) {
                        System.out.println(d8);
                    }
                    else {
                        System.out.println(" + " + d8);
                    }
                }
                System.out.println("Total Roll Value is " + totalRollValue);
                break;
            case "D10":
                for (int i = 0; i < rollAmount; i++) {
                    int d10 = random.nextInt(1, 11);
                    totalRollValue += d10;
                    if (i == 0) {
                        System.out.println(d10);
                    }
                    else {
                        System.out.println(" + " + d10);
                    }

                }
                System.out.println("Total Roll Value is " + totalRollValue);
                break;
            case "D12":
                for (int i = 0; i < rollAmount; i++) {
                    int d12 = random.nextInt(1, 13);
                    totalRollValue += d12;
                    if (i == 0) {
                        System.out.println(d12);
                    }
                    else {
                        System.out.println(" + " + d12);
                    }

                }
                System.out.println("Total Roll Value is " + totalRollValue);
                break;
            case "D20":
                for (int i = 0; i < rollAmount; i++) {
                    int d20 = random.nextInt(1, 21);
                    if (d20 == 1) {
                        System.out.println("...are you even trying?");
                    }
                    else if (d20 == 20) {
                        System.out.println("NICE! NAT20!");
                    }
                    totalRollValue += d20;
                    if (i == 0) {
                        System.out.println(d20);
                    }
                    else {
                        System.out.println(" + " + d20);
                    }

                }
                System.out.println("Total Roll Value is " + totalRollValue);
                break;
            default:
                System.out.println("Error! Invalid dice choice!");
        }
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
