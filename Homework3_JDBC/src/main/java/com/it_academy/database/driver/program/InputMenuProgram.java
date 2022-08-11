package com.it_academy.database.driver.program;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

public class InputMenuProgram {

    public static void printMenu() {
        System.out.println("""
                Please enter an action:\s
                1 - Register new user
                2 - Add new account
                3 - Pop up existing account
                4 - Withdraw cash
                5 - Exit the program""");
    }

    public static int inputOperation() throws NumberFormatException {
        boolean successfulInput = false;
        int valueInput = 0;
        do {
            printMenu();
            try {
                valueInput = greetingAndScanning();
                successfulInput = isInputCorrect(valueInput);
            } catch (NumberFormatException | InputMismatchException e) {
                out.println("Your input is not correct. Please try again\n");
            }
        } while (!successfulInput);
        return valueInput;
    }

    public static int greetingAndScanning() {
        out.println("\nEnter value of desired operation: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static boolean isInputCorrect(int operationInput) {
        boolean result;
        if (isInputWithinNumberOfActions(operationInput)) {
            result = true;
        } else {
            out.println("Your input is not correct. Please try again\n");
            result = false;
        }
        return result;
    }

    public static boolean isInputWithinNumberOfActions(int operationInput) {
        return operationInput == 1 || operationInput == 2 || operationInput == 3 ||
                operationInput == 4 || operationInput == 5;
    }

}
