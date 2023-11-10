package com.roxoft.lib;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FromTest {
    @Test
    public void canBeCreated(){
        assertNotNull(From.string("my test string"));
    }

    @Test
    public void toMD5Hex() throws NoSuchAlgorithmException {
        assertEquals("f863e8a642daed8446d16e4c8961780c".toUpperCase(), From.string("this is my test string").toMD5Hex());
    }


    @Test
    public void toSizeLimitedMD5Hex() throws NoSuchAlgorithmException {
        final From testObject = From.string("this is my test string");

        assertEquals("F8", testObject.toMD5Hex(1));
        assertEquals("F863", testObject.toMD5Hex(2));
        assertEquals("F863E8", testObject.toMD5Hex(3));
        assertEquals("F863E8A6", testObject.toMD5Hex(4));
        assertEquals("F863E8A642", testObject.toMD5Hex(5));
        assertEquals("F863E8A642DA", testObject.toMD5Hex(6));
        assertEquals("F863E8A642DAED8446D16E4C8961780C", testObject.toMD5Hex(100));
    }

    @Test
    public void toSizeLimitedMD5HexInputRange() throws NoSuchAlgorithmException {
        final From testObject = From.string("this is my test string");

        assertEquals("", testObject.toMD5Hex(0));
        assertEquals("F863E8A642DAED8446D16E4C8961780C", testObject.toMD5Hex(16));
        assertEquals("F863E8A642DAED8446D16E4C8961780C", testObject.toMD5Hex(100));
    }
}
