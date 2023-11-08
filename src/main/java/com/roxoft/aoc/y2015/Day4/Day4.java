package com.roxoft.aoc.y2015.Day4;

import com.roxoft.lib.Analyse;
import com.roxoft.lib.From;

import java.security.NoSuchAlgorithmException;

public class Day4 {
    private final String value;

    private Day4(final String input){
        value = input;
    }
    public static Day4 with(String input) {
        return new Day4(input);
    }

    public String solutionA() throws NoSuchAlgorithmException {
        for (long i = 0; i < Long.MAX_VALUE; i++){
            final String testValue = value + i;
            final String md5Hex = From.string(testValue).toMD5Hex();

            if (Analyse.string(md5Hex).startsWith(5, '0')){
                return testValue;
            }
        }

        throw new RuntimeException("No solution found for this input");
    }

    //XXX This is very slow
    public String solutionB() throws NoSuchAlgorithmException {
        for (long i = 0; i < Long.MAX_VALUE; i++){
            final String testValue = value + i;
            final String md5Hex = From.string(testValue).toMD5Hex();

            if (Analyse.string(md5Hex).startsWith(6, '0')){
                return testValue;
            }
        }

        throw new RuntimeException("No solution found for this input");
    }
}
