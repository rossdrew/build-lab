package com.roxoft.lib;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class From {
    /** The value to be converted. */
    private final String value;

    private From(final String input) {
        this.value = input;
    }

    /**
     * @param input a value to perform a conversion on.
     * @return a new {@link From} object from which to do a conversion.
     */
    public static From string(final String input) {
        return new From(input);
    }

    /**
     * @return An MD5 hashed {@link String} in hexadecimal.
     */
    public String toMD5Hex() throws NoSuchAlgorithmException {
        final byte[] bytesOfMessage = value.getBytes(StandardCharsets.UTF_8);
        final MessageDigest md = MessageDigest.getInstance("MD5");
        final byte[] mD5digest = md.digest(bytesOfMessage);
        final StringBuilder hexStringBuilder = new StringBuilder();
        for (byte md5Byte : mD5digest) {
            hexStringBuilder.append(String.format("%02X", md5Byte));
        }
        return hexStringBuilder.toString();
    }
}
