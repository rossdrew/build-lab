package com.roxoft.aoc.y2015.Day4;

import com.roxoft.lib.Analyse;
import com.roxoft.lib.From;

import java.security.NoSuchAlgorithmException;

public final class Day4 {
    /** The problem value being run. */
    private final String value;

    private Day4(final String input) {
        value = input;
    }

    /**
     * @param input the problem value to run the solution against.
     * @return A new {@link Day4} object for running the solution.
     */
    public static Day4 with(final String input) {
        return new Day4(input);
    }

    /**
     * @return The solution to problem A given the current setup.
     * @throws NoSuchAlgorithmException if MD5 algorithm is not present.
     */
    public String solutionA() throws NoSuchAlgorithmException {
        return solution(5);
    }

    /**
     * @return The solution to problem A given the current setup.
     * @throws NoSuchAlgorithmException if MD5 algorithm is not present.
     */
    public String solutionB() throws NoSuchAlgorithmException {
        return solution(6);
    }

    /**
     * XXX This is a very slow implementation, worth looking at optimisations.
     *
     * @param characterRepetitions number of character repetitions to look for.
     * @return The solution to problem given the current setup.
     * @throws NoSuchAlgorithmException if MD5 algorithm is not present.
     */
    private String solution(final int characterRepetitions) throws NoSuchAlgorithmException {
        final int requiredHexCharacters = characterRepetitions % 2 == 0 ? characterRepetitions : characterRepetitions + 1;
        int i = 0;
        while (true){
            final String testValue = value + i;
            final String md5Hex = From.string(testValue).toMD5Hex(requiredHexCharacters);

            if (Analyse.string(md5Hex).startsWith(characterRepetitions, '0')) {
                return testValue;
            }
            i++;
        }
    }
}
