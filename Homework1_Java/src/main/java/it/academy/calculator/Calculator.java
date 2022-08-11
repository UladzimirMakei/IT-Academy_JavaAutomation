package it.academy.calculator;

public class Calculator {
    private static boolean correctResult = true;

    public static String calculateResult(double numberOne, double numberTwo, char operation) {
        double result = 0;
        String resultOfCalculation;
        switch (operation) {
            case '+' -> result = add(numberOne, numberTwo);
            case '-' -> result = subtract(numberOne, numberTwo);
            case '*' -> result = multiply(numberOne, numberTwo);
            case '/' -> result = divide(numberOne, numberTwo);
        }
        if (correctResult) {
            resultOfCalculation = Double.toString(result);
        } else resultOfCalculation = "Result is beyond the limits";
        return resultOfCalculation;
    }

    private static double add(double numberOne, double numberTwo) {
        double result = 0;
        if (Double.isInfinite(numberOne + numberTwo)) {
            correctResult = false;
        } else result = numberOne + numberTwo;
        return result;
    }

    private static double subtract(double numberOne, double numberTwo) {
        double result = 0;
        if (Double.isInfinite(numberOne - numberTwo)) {
            correctResult = false;
        } else result = numberOne - numberTwo;
        return result;
    }

    private static double multiply(double numberOne, double numberTwo) {
        double result = 0;
        if (Double.isInfinite(numberOne * numberTwo)) {
            correctResult = false;
        } else result = numberOne * numberTwo;
        return result;
    }

    private static double divide(double numberOne, double numberTwo) {
        double result = 0;
        if (Double.isInfinite(numberOne / numberTwo)) {
            correctResult = false;
        } else result = numberOne / numberTwo;
        return result;
    }
}
