package com.roxoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanNumeral {
    public static String ZERO = "NULLA";

    private final String numeral;
    private int value = 0;

    private int characterValue(final String romanCharacter){
        switch (romanCharacter){
            case "I": return 1;
            case "V": return 5;
            case "X": return 10;
            case "L": return 50;
            case "C": return 100;
            case "D": return 500;
            case "M": return 1000;
            default: throw new InvalidNumeralException("'" + romanCharacter + "' is an unknown Roman numeral character");
        }
    }

    private RomanNumeral(final String numeral){
        if (numeral.isEmpty()){
            value = 0;
            this.numeral = ZERO;
            return;
        }else{
            this.numeral=numeral;
        }

        //get all the characters that are the same
        final List<Integer> asIntegers = Arrays.stream(numeral.split("")).map(this::characterValue).toList();
        final List<Integer> reduced = new ArrayList<>(List.of(asIntegers.get(0)));

        for (int c=1, previousValue=reduced.get(0), buildIndex=0, repetitionCount=1; c<asIntegers.size(); c++){
            int subject = asIntegers.get(c);
            if (subject == previousValue) {
                if (++repetitionCount > 3) {
                    throw new InvalidNumeralException("Roman characters (in this case '" + numeral.charAt(c) + "') cannot repeat more than 3 times");
                }
                reduced.set(buildIndex, reduced.get(buildIndex) + subject);
            }else{
                repetitionCount=1;
                if(subject > previousValue) {
                    reduced.set(buildIndex, subject - reduced.get(buildIndex));
                }else{
                    reduced.add(subject);
                }
                buildIndex++;
            }
            previousValue = subject;
        }

        value = reduced.stream().mapToInt(i->i).sum();

    }

    public static RomanNumeral of(final String s) {
        return new RomanNumeral(s);
    }

    public int numericalValue() {
        return value;
    }

    public String romanNotation() {
        return numeral;
    }
}