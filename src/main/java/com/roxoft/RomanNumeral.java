package com.roxoft;

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
                    throw new InvalidNumeralException("'"
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
        final List<Integer> reduced = new ArrayList<>(List.of(asIntegers.get(0)));

        for (int characterIndex = 1,
             previousValue = reduced.get(0),
             buildIndex = 0,
             repetitionCount = 1;
             characterIndex < asIntegers.size(); characterIndex++) {
            int subject = asIntegers.get(characterIndex);
            if (subject == previousValue) {
                if (UNREPEATABLES.contains(numeralString.substring(characterIndex, characterIndex + 1))) {
                    throw new InvalidNumeralException("Repeated instance of '" + numeralString.charAt(characterIndex) + "'. V, L or D cannot be repeated.");
                }
                if (++repetitionCount > 3) {
                    throw new InvalidNumeralException("Roman characters (in this case '" + numeralString.charAt(characterIndex) + "') cannot repeat more than 3 times");
                }
                reduced.set(buildIndex, reduced.get(buildIndex) + subject);
            } else {
                repetitionCount = 1;
                //TODO Pitest has identified a conditional boundary mutation here!
                if (subject > previousValue) {
                    if (SUBTRACTIVE.contains(numeralString.substring(characterIndex - 1, characterIndex))) {
                        reduced.set(buildIndex, subject - reduced.get(buildIndex));
                    } else {
                        throw new InvalidNumeralException("Use of '" + numeralString.charAt(characterIndex) + "' as subtractive character. Only I, X and C can be used as subtractive numerals.");
                    }
                } else {
                    reduced.add(subject);
                }
                buildIndex++;
            }
            previousValue = subject;
        }

        value = reduced.stream().mapToInt(i -> i).sum();

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
