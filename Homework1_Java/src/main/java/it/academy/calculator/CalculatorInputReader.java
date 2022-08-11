package it.academy.calculator;

import java.util.Scanner;

import static java.lang.System.out;

public class CalculatorInputReader {

    private static char operation;

    public static double inputValue() {
        double value = 0;
        boolean successfulInput = false;
        do {
            try {
                out.println("Enter a number: ");
                Scanner scanner = new Scanner(System.in);
                value = Double.parseDouble(scanner.nextLine().replace(',', '.'));
                if (divideByZero(value, operation)) {
                    out.print("It's prohibited to divide by 0. ");
                    typeIncorrect();
                } else if (infiniteOrNanValue(value)) {
                    typeIncorrect();
                } else {
                    successfulInput = true;
                }
            } catch (NumberFormatException e) {
                typeIncorrect();
            }
        } while (!successfulInput);
        return value;
    }

    private static boolean infiniteOrNanValue(double value) {
        return Double.isNaN(value) || Double.isInfinite(value);
    }

    private static boolean divideByZero(double value, char operation) {
        return value == 0 && operation == '/';
    }

    private static void typeIncorrect() {
        out.println("Your input is not correct. Please try again");
    }

    public static char inputOperation() {
        char operation = 0;
        boolean successfulInput = false;
        String operationInput;
        do {
            out.println("Enter arithmetic operation '+' '-' '*' '/': ");
            Scanner scanner = new Scanner(System.in);
            operationInput = scanner.nextLine();
            if (operationInput.length() == 1) {
                operation = operationInput.charAt(0);
                if (correctOperationInput(operation)) {
                    successfulInput = true;
                } else {
                    typeIncorrect();
                }
            } else {
                typeIncorrect();
            }
        } while (!successfulInput);
        CalculatorInputReader.operation = operation;
        return operation;
    }

    private static boolean correctOperationInput(char operation) {
        return operation == '+' || operation == '-' || operation == '/' || operation == '*';
    }
}
