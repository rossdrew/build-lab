package com.roxoft.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class RomanNumeral {
    /** Roman notation for ZERO. */
    public static final String ZERO = "NULLA";

    /** Characters which cannot be repeated in a Roman numeral. */
    private static final String UNREPEATABLES = "VLD";
    /** Characters which can be used as a subtractive in a Roman numeral. */
    private static final String SUBTRACTIVE = "IXC";

    /** The Roman numeral String in question. */
    private final String numeral;
    /** A numerical representation of the Roman numeral in question. */
    private final int value;

    @SuppressWarnings("magicnumber")
    private int characterValue(final String romanCharacter) {
        return switch (romanCharacter) {
            case "I" -> 1;
            case "V" -> 5;
            case "X" -> 10;
            case "L" -> 50;
            case "C" -> 100;
            case "D" -> 500;
            case "M" -> 1000;
            default ->
                    throw new InvalidRomanNumeralException("'"
                            + romanCharacter
                            + "' is an unknown Roman numeral character"
                    );
        };
    }

    private RomanNumeral(final String numeralString) {
        if (numeralString.isEmpty()) {
            value = 0;
            this.numeral = ZERO;
            return;
        } else {
            this.numeral = numeralString;
        }

        //get all the characters that are the same
        final List<Integer> asIntegers = Arrays.stream(numeralString.split(""))
                .map(this::characterValue)
                .toList();
        final List<Integer> calculatedValues = new ArrayList<>(List.of(asIntegers.get(0)));

        for (int characterIndex = 1,
             previousValue = calculatedValues.get(0),
             calculatedValueIndex = 0,
             characterRepetitionCount = 1;
             characterIndex < asIntegers.size(); characterIndex++) {
            int subject = asIntegers.get(characterIndex);

            if (subject > previousValue) {
                characterRepetitionCount = 1;
                if (SUBTRACTIVE.contains(numeralString.substring(characterIndex - 1, characterIndex))) {
                    calculatedValues.set(calculatedValueIndex, subject - calculatedValues.get(calculatedValueIndex));
                } else {
                    throw new InvalidRomanNumeralException("Use of '" + numeralString.charAt(characterIndex) + "' as subtractive character. Only I, X and C can be used as subtractive numerals.");
                }
            } else if (subject == previousValue) {
                if (UNREPEATABLES.contains(numeralString.substring(characterIndex, characterIndex + 1))) {
                    throw new InvalidRomanNumeralException("Repeated instance of '" + numeralString.charAt(characterIndex) + "'. V, L or D cannot be repeated.");
                }
                if (++characterRepetitionCount > 3) {
                    throw new InvalidRomanNumeralException("Roman characters (in this case '" + numeralString.charAt(characterIndex) + "') cannot repeat more than 3 times");
                }
                calculatedValues.set(calculatedValueIndex, calculatedValues.get(calculatedValueIndex) + subject);
            } else {
                characterRepetitionCount = 1;
                calculatedValues.add(subject);
                calculatedValueIndex++;
            }
            previousValue = subject;
        }

        value = calculatedValues.stream().mapToInt(i -> i).sum();

    }

    /**
     * @param numeralString a Roman numeral String.
     * @return a {@link RomanNumeral} of the provided String.
     */
    public static RomanNumeral of(final String numeralString) {
        return new RomanNumeral(numeralString);
    }

    /** @return the numerical value of this Roman numeral. */
    public int numericalValue() {
        return value;
    }

    /** @return the String representation of this Roman numeral. */
    public String romanNotation() {
        return numeral;
    }
}
