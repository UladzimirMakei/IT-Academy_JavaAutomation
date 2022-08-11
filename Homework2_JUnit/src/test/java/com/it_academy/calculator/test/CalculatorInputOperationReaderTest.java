package com.it_academy.calculator.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.it_academy.calculator.frame.CalculatorInputOperationReader.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorInputOperationReaderTest {

    @ParameterizedTest
    @CsvSource(value = {"-, -", "+, +", "/, /", "*, *"})
    void testScannerInputWithValidOperations(String inputValue, String resultValue) throws InterruptedException {
        InputStream in = new ByteArrayInputStream(inputValue.getBytes());
        System.setIn(in);
        assertThat(resultValue).withFailMessage("Scanning input method for operations does not work").
                isEqualTo(greetingAndScanning());
        Thread.sleep(1000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"/", "+", "*", "-"})
    void testInputCheckCorrectOperationWithSimpleValues(String value) throws InterruptedException {
        assertTrue(correctInput(value),
                "Check for operation input with simple values does not work");
        Thread.sleep(1000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+3", " +", "--", "@", " "})
    void testInputCheckCorrectOperationWithInvalidValues(String value) throws InterruptedException {
        assertFalse(correctInput(value), "Check for operation input with invalid values does not work");
        Thread.sleep(1000);
    }
}