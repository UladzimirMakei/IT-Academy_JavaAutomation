import it.academy.calculator.Calculator;
import it.academy.calculator.CalculatorInputReader;

import static it.academy.calculator.Calculator.*;
import static it.academy.calculator.CalculatorInputReader.*;

public class Demo {
    public static void main(String[] args) {

        //ввод числа #1
        double numberOne = inputValue();
        //ввод арифметических операций
        char operation = inputOperation();
        //ввод числа #2
        double numberTwo = inputValue();
        //вывод результата
        System.out.println(calculateResult(numberOne, numberTwo, operation));

    }
}
