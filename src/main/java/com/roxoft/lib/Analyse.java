package com.roxoft.lib;

import java.util.Arrays;

public final class Analyse {
    /** The value to be analysed. */
    private final String value;

    private Analyse(final String input) {
        this.value = input;
    }

    /**
     * @param input the value to be analysed.
     * @return a new {@link Analyse} object for running analysis.
     */
    public static Analyse string(final String input) {
        return new Analyse(input);
    }

    /**
     * @param numberOfRepetitions a number of expected repeitions of a given character.
     * @param repeatingCharacter a character expected to repeat a given number of times.
     * @return true if given character repeats given number of times, false otherwise.
     */
    public boolean startsWith(final int numberOfRepetitions, final char repeatingCharacter) {
        if (value.length() < numberOfRepetitions) {
            return false;
        }

        char[] charArray = new char[numberOfRepetitions];
        Arrays.fill(charArray, repeatingCharacter);
        final String prefix = new String(charArray);

        return value.startsWith(prefix);
    }
}
