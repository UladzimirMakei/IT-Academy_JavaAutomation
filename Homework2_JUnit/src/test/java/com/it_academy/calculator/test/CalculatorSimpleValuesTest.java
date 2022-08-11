package com.it_academy.calculator.test;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.it_academy.calculator.frame.Calculator.*;
import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
public class CalculatorSimpleValuesTest {

    @ParameterizedTest
    @CsvSource(value = {"2, 2, '+', 4.0", "2, 2, '-', 0.0", "2, 2, '*', 4.0", "2, 2, '/', 1.0"})
    void testSimpleValuesAllTypesOfOperation
            (double firstValue, double secondValue, char operation, String result) throws InterruptedException {
        assertThat(result).withFailMessage("Simple values with different operations do not work").
                isEqualTo(calculateResult(firstValue, secondValue, operation));
        Thread.sleep(1000);
    }

    @ParameterizedTest
    @CsvSource(value = {"31, 15, 46.0", "31, 0 , 31.0", "-31, -15, -46.0", "31.35, 15.5, 46.85"})
    void testAddSimpleValues(double firstValue, double secondValue, String result) throws InterruptedException {
        assertThat(result)
                .withFailMessage("Addition simple values does not work").isEqualTo(add(firstValue, secondValue));
        Thread.sleep(1000);
    }

    @ParameterizedTest
    @CsvSource(value = {"31, 15, 16.0", "31, 0 , 31.0", "-31, -15, -16.0", "31.5, 15.35, 16.15"})
    void testSubtractSimpleValues(double firstValue, double secondValue, String result) throws InterruptedException {
        assertThat(result).withFailMessage("Subtract simple values does not work").
                isEqualTo(subtract(firstValue, secondValue));
        Thread.sleep(1000);
    }

    @ParameterizedTest
    @CsvSource(value = {"31, 15, 465.0", "31, 0 , 0.0", "-31, -15, 465.0", "31.5, 15.35, 483.525"})
    void testMultiplySimpleValues(double firstValue, double secondValue, String result) throws InterruptedException {
        assertThat(result).withFailMessage("Multiply simple values does not work").
                isEqualTo(multiply(firstValue, secondValue));
        Thread.sleep(1000);
    }

    @ParameterizedTest
    @CsvSource(value = {"30, 15, 2.0", "-30, -15 , 2.0", "31.35, 15.5, 2.02258064516129"})
    void testAddDivideSimpleValues(double firstValue, double secondValue, String result) throws InterruptedException {
        assertThat(result).withFailMessage("Dividing simple values does not work").
                isEqualTo(divide(firstValue, secondValue));
        Thread.sleep(1000);
    }

    @ParameterizedTest
    @CsvSource(value = {"10, 10.0", "0, 0.0", "1.9976931348623157E308, Result is beyond the limits"})
    void testForInfiniteValueOrNanValue(double value, String result) throws InterruptedException {
        assertThat(result).withFailMessage("Check for Infinite or Nan value does not work").
                isEqualTo(checkResult(value));
        Thread.sleep(1000);
    }
}