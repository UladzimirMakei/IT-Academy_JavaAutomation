package by.itacademy.JavaAutomation.Task1.Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

public class Calculator {
    private static double valueOne, valueTwo;
    private static char operation;

    public static void setValueOne() {
        Calculator.valueOne = Calculator.inputValue();
    }

    public static void setOperation() {
        Calculator.operation = Calculator.inputOperation();
    }

    public static void setValueTwo() {
        Calculator.valueTwo = Calculator.inputValue();
    }

    private static double inputValue() {
        double value = 0;
        boolean successfulInput = false;
        do {
            try {
                out.println("Enter a number: ");
                Scanner scanner = new Scanner(System.in);
                value = scanner.nextDouble();
                if (value == 0 && operation == '/'){
                    out.println("It's prohibited to divide by 0. Your input is not correct. Please try again.");
                } else if (Double.isNaN(value) || Double.isInfinite(value)) {
                    typeIncorrect();
                } else {
                    successfulInput = true;
                }
            } catch (InputMismatchException e) {
                typeIncorrect();
            }
        } while (!successfulInput);
         return value;
    }


    private static char inputOperation() {
        char operation;
        boolean successfulInput = false;
        do {
                out.println("Enter arithmetic operation '+' '-' '*' '/': ");
                Scanner scanner = new Scanner(System.in);
                operation = scanner.next().charAt(0);
                if (operation == '+' || operation == '-' || operation == '/' || operation == '*') {
                    successfulInput = true;
                } else {
                    typeIncorrect();
                }
            } while (!successfulInput);
        return operation;
    }

    private static void typeIncorrect() {
        out.println("Your input is not correct. Please try again");
    }

    public static void calculateResult() {
        switch (operation){
            case '+' ->  add();
            case '-' ->  subtract();
            case '*' ->  multiply();
            case '/' ->  divide();
        }
    }

    private static void add() {
        checkAndPrintResult(valueOne+valueTwo);
    }

    private static void subtract() {
        checkAndPrintResult(valueOne-valueTwo);
    }

    private static void multiply() {
        checkAndPrintResult(valueOne*valueTwo);
    }

    private static void divide() {
        checkAndPrintResult(valueOne/valueTwo);
    }

    private static void checkAndPrintResult(double result){
        if(Double.isNaN(result) || Double.isInfinite(result))
            out.println("Result is beyond limits. Please try again");
        else out.println("Your result is: \n" + result);
    }
}






