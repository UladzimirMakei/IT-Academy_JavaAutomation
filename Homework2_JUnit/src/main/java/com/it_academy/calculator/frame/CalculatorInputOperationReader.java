package com.it_academy.calculator.frame;

import java.util.Scanner;

import static java.lang.System.out;

public class CalculatorInputOperationReader {

    public static char inputOperation() {
        boolean successfulInput = false;
        String operationInput;
        do {
            operationInput = greetingAndScanning();
            if (correctInput(operationInput)) {
                successfulInput = true;
            } else {
                out.println("Your input is not correct. Please try again");
            }
        } while (!successfulInput);
        return operationInput.charAt(0);
    }

    public static String greetingAndScanning() {
        out.println("Enter arithmetic operation '+' '-' '*' '/': ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean correctInput(String operationInput) {
        return (operationInput.length() == 1) && (operationInput.charAt(0) == '+' || operationInput.charAt(0) == '-'
                || operationInput.charAt(0) == '/' || operationInput.charAt(0) == '*');
    }
}
