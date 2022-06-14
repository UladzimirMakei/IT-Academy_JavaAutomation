
public class CalculatorRun {
        public static void main(String[] args) {

            //ввод числа #1
            double numberOne = CalculatorInputReader.inputValue();
            //ввод арифметических операций
            char operation = CalculatorInputReader.inputOperation();
            //ввод числа #2
            double numberTwo = CalculatorInputReader.inputValue();
            //вывод результата
            System.out.println(Calculator.calculateResult(numberOne, numberTwo, operation));

        }
    }
