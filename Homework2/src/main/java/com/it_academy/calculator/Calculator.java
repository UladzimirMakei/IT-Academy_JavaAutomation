package com.it_academy.calculator;

    public class Calculator {
        public static String calculateResult(double numberOne, double numberTwo, char operation) {
            String result = null;
            switch (operation) {
                case '+' -> result = add(numberOne, numberTwo);
                case '-' -> result = subtract(numberOne, numberTwo);
                case '*' -> result = multiply(numberOne, numberTwo);
                case '/' -> result = divide(numberOne, numberTwo);
            }
            return result;
        }

        public static String add(double numberOne, double numberTwo) {
            return checkResult(numberOne+numberTwo);
        }

        public static String subtract(double numberOne, double numberTwo) {
            return checkResult(numberOne-numberTwo);
        }

        public static String multiply(double numberOne, double numberTwo) {
            return checkResult(numberOne*numberTwo);
        }

        public static String divide(double numberOne, double numberTwo) {
            String result;
            if(numberTwo==0){
              result = "It's prohibited to divide by 0. Your input is not correct";
            } else result = checkResult(numberOne/numberTwo);
            return result;
        }

        public static String checkResult (double value){
            String result;
            if (!Double.isInfinite(value))  {
                result = Double.toString(value);
            } else result = "Result is beyond the limits";
            return result;
        }

    }
