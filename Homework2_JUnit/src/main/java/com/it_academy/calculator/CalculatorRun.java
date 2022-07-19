package com.it_academy.calculator;
public class CalculatorRun {
        public static void main(String[] args) {

            //ввод числа #1
            double numberOne = CalculatorInputValueReader.inputValue();
            //ввод арифметических операций
            char operation = CalculatorInputOperationReader.inputOperation();
            //ввод числа #2
            double numberTwo = CalculatorInputValueReader.inputValue();
            //вывод результата
            System.out.println(Calculator.calculateResult(numberOne, numberTwo, operation));

        }
    }
