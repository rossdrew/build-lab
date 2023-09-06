package com.roxoft.test;

public class InvalidRomanNumeralException extends RuntimeException {
    /**
     * Create a new {@link InvalidRomanNumeralException} with a {@code message}.
     *
     * @param message the specified message with information on what has been found to be invalid
     */
    public InvalidRomanNumeralException(final String message) {
        super(message);
    }
}
