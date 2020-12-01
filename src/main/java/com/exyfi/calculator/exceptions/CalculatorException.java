package com.exyfi.calculator.exceptions;

/**
 * Base exception of this app.
 */
public class CalculatorException extends RuntimeException {

    public CalculatorException(String message) {
        super(message);
    }

    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
