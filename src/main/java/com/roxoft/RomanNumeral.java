package com.roxoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanNumeral {
    public static String ZERO = "NULLA";

    private static String UNREPEATABLES = "VLD";
    private static String SUBTRACTIVE = "IXC";

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

        for (int characterIndex=1, previousValue=reduced.get(0), buildIndex=0, repetitionCount=1; characterIndex<asIntegers.size(); characterIndex++){
            int subject = asIntegers.get(characterIndex);
            if (subject == previousValue) {
                if (UNREPEATABLES.contains(numeral.substring(characterIndex,characterIndex+1))){
                    throw new InvalidNumeralException("Repeated instance of '" + numeral.substring(characterIndex,characterIndex+1) + "'. V, L or D cannot be repeated.");
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
                        throw new InvalidNumeralException("Use of '" + numeral.substring(characterIndex,characterIndex+1) + "' as subtractive character. Only I, X and C can be used as subtractive numerals.");
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