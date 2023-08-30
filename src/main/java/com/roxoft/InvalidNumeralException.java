package com.roxoft;

public class InvalidNumeralException extends RuntimeException {
    /**
     * Create a new {@link com.roxoft.InvalidNumeralException} with a {@code message}.
     *
     * @param message the specified message with information on what has been found to be invalid
     */
    public InvalidNumeralException(final String message) {
        super(message);
    }
}
