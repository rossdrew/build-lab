package com.roxoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanNumeral {
    public static String ZERO = "NULLA";

    private final static String UNREPEATABLES = "VLD";
    private final static String SUBTRACTIVE = "IXC";

    private final String numeral;
    private final int value;

    private int characterValue(final String romanCharacter){
        return switch (romanCharacter) {
            case "I" -> 1;
            case "V" -> 5;
            case "X" -> 10;
            case "L" -> 50;
            case "C" -> 100;
            case "D" -> 500;
            case "M" -> 1000;
            default ->
                    throw new InvalidNumeralException("'" + romanCharacter + "' is an unknown Roman numeral character");
        };
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

        for (int characterIndex=1, previousValue=reduced.get(0), buildIndex=0, repetitionCount=1; characterIndex<asIntegers.size(); characterIndex++){
            int subject = asIntegers.get(characterIndex);
            if (subject == previousValue) {
                if (UNREPEATABLES.contains(numeral.substring(characterIndex,characterIndex+1))){
                    throw new InvalidNumeralException("Repeated instance of '" + numeral.charAt(characterIndex) + "'. V, L or D cannot be repeated.");
                }
                if (++repetitionCount > 3) {
                    throw new InvalidNumeralException("Roman characters (in this case '" + numeral.charAt(characterIndex) + "') cannot repeat more than 3 times");
                }
                reduced.set(buildIndex, reduced.get(buildIndex) + subject);
            }else{
                repetitionCount = 1;
                //TODO Pitest has identified a conditional boundary mutation here!
                if (subject > previousValue) {
                    if (SUBTRACTIVE.contains(numeral.substring(characterIndex-1,characterIndex))) {
                        reduced.set(buildIndex, subject - reduced.get(buildIndex));
                    }else{
                        throw new InvalidNumeralException("Use of '" + numeral.charAt(characterIndex) + "' as subtractive character. Only I, X and C can be used as subtractive numerals.");
                    }
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