package com.roxoft;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.roxoft.RomanNumeral.ZERO;
import static org.junit.jupiter.api.Assertions.*;

/**
     I, V, X, L, C, D, and M which represent the numbers 1, 5, 10, 50, 100, 500, and 1000 respectively.
        Rule 1: When certain numerals are repeated, the number represented by them is their sum. For example, II = 1 + 1 = 2, or XX = 10 + 10 = 20, or, XXX = 10 + 10 + 10 = 30.
        Rule 2: It is to be noted that no Roman numerals can come together more than 3 times. For example, we cannot write 40 as XXXX
        Rule 3: The letters V, L, and D are not repeated.
        Rule 4: Only I, X, and C can be used as subtractive numerals. There can be 6 combinations when we subtract. These are IV = 5 - 1 = 4; IX = 10 - 1 = 9; XL = 50 - 10 = 40; XC = 100 - 10 = 90; CD = 500 - 100 = 400; and CM = 1000 - 100 = 900
        Rule 5: When a Roman numeral is placed after another Roman numeral of greater value, the result is the sum of the numerals. For example, VIII = 5 + 1 + 1 + 1 = 8, or, XV = 10 + 5 = 15,
        Rule 6: When a Roman numeral is placed before another Roman numeral of greater value, the result is the difference between the numerals. For example, IV = 5 - 1 = 4, or, XL = 50 - 10 = 40, or XC = 100 - 10 = 90
        Rule 7: When a Roman numeral of a smaller value is placed between two numerals of greater value, it is subtracted from the numeral on its right. For example, XIV = 10 + (5 - 1) = 14, or, XIX = 10 + (10 - 1) = 19
        Rule 8: To multiply a number by a factor of 1000 a bar is placed over it.
        Rule 9: Roman numerals do not follow any place value system.
        Rule 10: There is no Roman numeral for zero (0).
 */

public class RomanNumeralTest {
    @Test
    public void testEmpty(){
        //Rule 10: There is no Roman numeral for zero (0).
        final String testValue = "";
        final int expectedValue = 0;

        final RomanNumeral numeral = RomanNumeral.of(testValue);

        assertEquals(expectedValue, numeral.numericalValue(), "'" + testValue + "' string should be equal to " + expectedValue);
        assertEquals(ZERO, numeral.romanNotation(), expectedValue + " in Roman notation is expected to be '" + testValue + "'");
    }

    @ParameterizedTest
    @CsvSource({
            "I,1",
            "II,2",
            "III,3",
            "IV,4",
            "V,5",
            "VI,6",
            "VII,7",
            "VIII,8",
            "IX,9",
            "X,10",
            "XI,11",
            "XII,12",
            "XIII,13",
            "XV,15",
            "XVI,16",
            "XVII,17",
            "XVIII,18",
            "XIX,19",
            "XX,20",
            "XXI,21"
    })
    public void testRandomNumers(String testValue, int expectedValue){
        final RomanNumeral numeral = RomanNumeral.of(testValue);

        assertEquals(expectedValue, numeral.numericalValue(), "'" + testValue + "' string should be equal to " + expectedValue);
        assertEquals(testValue, numeral.romanNotation(), expectedValue + " in Roman notation is expected to be '" + testValue + "'");
    }

    @ParameterizedTest
    @CsvSource({
            "I,1",
            "V,5",
            "X,10",
            "L,50",
            "C,100",
            "D,500",
            "M,1000",

    })
    public void testSimpleNumbers(String testValue, int expectedValue){
        final RomanNumeral numeral = RomanNumeral.of(testValue);

        assertEquals(expectedValue, numeral.numericalValue(), "'" + testValue + "' string should be equal to " + expectedValue);
        assertEquals(testValue, numeral.romanNotation(), expectedValue + " in Roman notation is expected to be '" + testValue + "'");
    }

    @ParameterizedTest
    @CsvSource({
            //Rule 1: When certain numerals are repeated, the number represented by them is their sum.
            "II,2",
            "III,3",
            "XX,20",
            "XXX,30"
    })
    public void testRepeatedNumerals(String testValue, int expectedValue){
        final RomanNumeral numeral = RomanNumeral.of(testValue);

        assertEquals(expectedValue, numeral.numericalValue(), "'" + testValue + "' string should be equal to " + expectedValue);
        assertEquals(testValue, numeral.romanNotation(), expectedValue + " in Roman notation is expected to be '" + testValue + "'");
    }

    @ParameterizedTest
    @CsvSource({
            //Rule 2: It is to be noted that no Roman numerals can come together more than 3 times.
            "IIII",
            "VVVV",
            //Rule 3: The letters V, L, and D are not repeated.
            "VV",
            "LL",
            "DD",
            //Rule 4: Only I, X, and C can be used as subtractive numerals
            "VX",
            "VL",
            "VC",
            "VD",
            "VM",
            "LC",
            "LD",
            "LM",
            "DM"
    })
    public void testInvalid(String testValue){
        RomanNumeral numeral = null;
        try {
            numeral = RomanNumeral.of(testValue);
            fail("Error expected!");
        }catch (InvalidNumeralException e){
            assertNull(numeral);
        }
    }

    @ParameterizedTest
    @CsvSource({
            //Rule 5: When a Roman numeral is placed after another Roman numeral of greater value, the result is the sum of the numerals.
            "VI,6",
            "XV,15",
            "LX,60",
            "VIII,8"
    })
    public void testSimpleAddition(String testValue, int expectedValue){
        final RomanNumeral numeral = RomanNumeral.of(testValue);

        assertEquals(expectedValue, numeral.numericalValue(), "'" + testValue + "' string should be equal to " + expectedValue);
        assertEquals(testValue, numeral.romanNotation(), expectedValue + " in Roman notation is expected to be '" + testValue + "'");
    }

    @ParameterizedTest
    @CsvSource({
            //Rule 6: When a Roman numeral is placed before another Roman numeral of greater value, the result is the difference between the numerals.
            "IV,4",
            "IX,9",
            "XL,40",
            "XC,90",
            "CD,400",
            "CM,900",
            //Rule 7: When a Roman numeral of a smaller value is placed between two numerals of greater value, it is subtracted from the numeral on its right.
            "XIV,14",
            "XIX,19"
    })
    public void testSimpleSubtraction(String testValue, int expectedValue){
        final RomanNumeral numeral = RomanNumeral.of(testValue);

        assertEquals(expectedValue, numeral.numericalValue(), "'" + testValue + "' string should be equal to " + expectedValue);
        assertEquals(testValue, numeral.romanNotation(), expectedValue + " in Roman notation is expected to be '" + testValue + "'");
    }
}
