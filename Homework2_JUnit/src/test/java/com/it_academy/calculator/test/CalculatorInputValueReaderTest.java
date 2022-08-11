package com.it_academy.calculator.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.it_academy.calculator.frame.CalculatorInputValueReader.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@Execution(ExecutionMode.CONCURRENT)
class CalculatorInputValueReaderTest {

    @ParameterizedTest
    @CsvSource(value = {"9, 9.0", "0 , 0.0", "10.55, 10.55", "-45, -45.0"})
    void testNumberInputWithValidNumbers(String inputValue, Double resultValue) throws InterruptedException {
        InputStream in = new ByteArrayInputStream(inputValue.getBytes());
        System.setIn(in);
        assertThat(resultValue).withFailMessage("Main input method for numbers does not work").
                isEqualTo(inputValue());
        Thread.sleep(1000);
    }

    @ParameterizedTest
    @CsvSource(value = {"9, 9", "0 , 0", "10.55, 10.55", "-45, -45"})
    void testScannerInputWithValidNumbers(String inputValue, String resultValue) throws InterruptedException {
        InputStream in = new ByteArrayInputStream(inputValue.getBytes());
        System.setIn(in);
        assertThat(resultValue).withFailMessage("Scanning input method for numbers does not work").
                isEqualTo(greetingAndScanning());
        Thread.sleep(1000);
    }

    @Test
    void testScannerInputWithNumberWithComma() throws InterruptedException {
        String inputValue = "15,5";
        InputStream in = new ByteArrayInputStream(inputValue.getBytes());
        System.setIn(in);
        assertThat("15.5").withFailMessage("Scanning input method for numbers with comma does not work").
                isEqualTo(greetingAndScanning());
        Thread.sleep(1000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10", "0.0", "-10", "55.465"})
    void testInputCheckInfiniteOrNanWithSimpleValues(String value) throws InterruptedException {
        assertTrue(correctInput(value), "Check for infinite or Nan with simple values does not work");
        Thread.sleep(1000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.8976931348623157E308", "-1.8976931348623157E308"})
    void testInputCheckInfiniteOrNanWithInvalidValues(String value) throws InterruptedException {
        assertFalse(correctInput(value), "Check for infinite or Nan with invalid values does not work");
        Thread.sleep(1000);
    }
}