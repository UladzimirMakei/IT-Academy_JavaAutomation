package com.it_academy.calculator;

import java.util.Scanner;

import static java.lang.System.out;

public class CalculatorInputValueReader {

    public static double inputValue() throws NumberFormatException {
        boolean successfulInput = false;
        String valueInput ="0";
        do {
            try {
                valueInput = greetingAndScanning();
                successfulInput = correctInput(valueInput);
            } catch (NumberFormatException e) {
                out.println("Your input is not correct. Please try again");
            }
        } while (!successfulInput);
        return Double.parseDouble(valueInput);
    }

    public static String greetingAndScanning() {
        out.println("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().replace(',', '.');
    }

    public static boolean correctInput(String value) {
        boolean result;
        if (!Double.isNaN(Double.parseDouble(value)) && !Double.isInfinite(Double.parseDouble(value))){
            result = true;
        } else {
            out.println("Your input is not correct. Please try again");
            result = false;
        }
        return result;
    }
}
