package com.it_academy.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
public  class CalculatorExceptionValuesTest {
private final String RESULT_BEYOND = "Result is beyond the limits";

    @ParameterizedTest
    @CsvSource (value = {"1.7976931348623157E308, 1.7976931348623157E308, '+'",
            "-1.7976931348623157E308, 1.7976931348623157E308, '-'",
            "1.1, 1.7976931348623157E308, '*'",
            "1.7976931348623157E308, 0.1, '/'"})
    void testAllOperationsResultBeyondLimit (double firstValue, double secondValue, char operation) throws InterruptedException {
        assertThat(RESULT_BEYOND).withFailMessage("Result of operation " + operation + " beyond type limit does not work").
                isEqualTo(Calculator.calculateResult(firstValue, secondValue, operation));
        Thread.sleep(1000);
    }

    @Test
    void testAddResultBeyondTypeLimit() throws InterruptedException {
        assertThat(RESULT_BEYOND).withFailMessage("Result of addition beyond type limit does not work").
                isEqualTo(Calculator.add(Double.MAX_VALUE, Double.MAX_VALUE));
        Thread.sleep(1000);
    }

    @Test
    void testSubtractResultBeyondTypeLimit() throws InterruptedException {
        assertThat(RESULT_BEYOND).withFailMessage("Result of subtraction beyond type limit does not work").
                isEqualTo(Calculator.subtract(-Double.MAX_VALUE, Double.MAX_VALUE));
        Thread.sleep(1000);
    }

    @Test
    void testMultiplyResultBeyondTypeLimit() throws InterruptedException {
        assertThat(RESULT_BEYOND).withFailMessage("Result of multiplication beyond type limit does not work").
                isEqualTo(Calculator.multiply(Double.MAX_VALUE, 1.1));
        Thread.sleep(1000);
    }

    @Test
    void testDivideResultBeyondTypeLimit() throws InterruptedException {
        assertThat(RESULT_BEYOND).withFailMessage("Result of dividing beyond type limit does not work").
                isEqualTo(Calculator.divide(1.1, Double.MIN_VALUE));
        Thread.sleep(1000);
    }

    @ParameterizedTest
    @CsvSource(value = {"5, 0", "0, 0"})
    void testDivideByZero(double firstValue, double secondValue) throws InterruptedException {
        assertThat("It's prohibited to divide by 0. Your input is not correct").withFailMessage("Calculator allows to divide by zero").
                isEqualTo(Calculator.divide(firstValue, secondValue));
        Thread.sleep(1000);
    }
}