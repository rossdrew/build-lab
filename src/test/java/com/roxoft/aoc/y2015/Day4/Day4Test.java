package com.roxoft.aoc.y2015.Day4;

import com.roxoft.lib.Analyse;
import com.roxoft.lib.From;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * --- Day 4: The Ideal Stocking Stuffer ---
 * Santa needs help mining some AdventCoins (very similar to bitcoins) to use as gifts for all the economically
 * forward-thinking little girls and boys.
 *
 * To do this, he needs to find MD5 hashes which, in hexadecimal, start with at least five zeroes. The input to the MD5
 * hash is some secret key (your puzzle input, given below) followed by a number in decimal. To mine AdventCoins, you
 * must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...) that produces such a hash.
 *
 * For example:
 *
 * If your secret key is abcdef, the answer is 609043, because the MD5 hash of abcdef609043 starts with five zeroes
 * (000001dbbfa...), and it is the lowest such number to do so.
 * If your secret key is pqrstuv, the lowest number it combines with to make an MD5 hash starting with five zeroes is
 * 1048970; that is, the MD5 hash of pqrstuv1048970 looks like 000006136ef....
 *
 * --- Part Two ---
 * Now find one that starts with six zeroes.
 */
//@Timeout(value = 30, unit = TimeUnit.SECONDS)
public class Day4Test {
    @Test
    public void requirement_stringToMD5Hex() throws NoSuchAlgorithmException {
        assertEquals("000001dbbfa3a5c83a2d506429c7b00e".toUpperCase(), From.string("abcdef609043").toMD5Hex());
        assertEquals("000006136ef2ff3b291c85725f17325c".toUpperCase(), From.string("pqrstuv1048970").toMD5Hex());
    }

    @Test
    public void requirement_detectFiveZeroes() {
        assertTrue(Analyse.string("000001dbbfa3a5c83a2d506429c7b00e").startsWith(5, '0'));
        assertTrue(Analyse.string("000006136ef2ff3b291c85725f17325c").startsWith(5, '0'));

        assertFalse(Analyse.string("00006136ef2ff3b291c85725f17325c").startsWith(5, '0'));
        assertFalse(Analyse.string("12345").startsWith(5, '0'));
        assertFalse(Analyse.string("1234").startsWith(5, '0'));
    }

//    @Test
//    public void requirement_findNextFiveZeroMD5(){
//        assertEquals("abcdef609043".toUpperCase(), Day4.for("a"));
//    }

    @Test
    public void example_A1() throws NoSuchAlgorithmException {
        assertEquals("abcdef609043", Day4.with("abcdef").solutionA());
    }

    @Test
    public void example_A2() throws NoSuchAlgorithmException {
        assertEquals("pqrstuv1048970", Day4.with("pqrstuv").solutionA());
    }

    @Test
    public void solution_A() throws NoSuchAlgorithmException {
        assertEquals("iwrupvqb346386", Day4.with("iwrupvqb").solutionA());
    }

    @Test
    public void solution_B() throws NoSuchAlgorithmException {
        assertEquals("iwrupvqb9958218", Day4.with("iwrupvqb").solutionB());
    }

    @Test
    public void randomTest() throws NoSuchAlgorithmException {
        assertEquals("?", Day4.with("").solutionB());
    }
}
