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
     * @throws NoSuchAlgorithmException if MD5 cannot be used for any reason
     */
    public String toMD5Hex() throws NoSuchAlgorithmException {
        return toMD5Hex(16);
    }

    /**
     * @param hexCharacters number of hex characters to convert from the start. Max 16
     * @return An MD5 hashed {@link String} of the specified number of charactes in hexadecimal.
     * @throws NoSuchAlgorithmException if MD5 cannot be used for any reason
     */
    public String toMD5Hex(int hexCharacters) throws NoSuchAlgorithmException {
        if (hexCharacters > 16){
            hexCharacters = 16;
        }
        final byte[] bytesOfMessage = value.getBytes(StandardCharsets.UTF_8);
        final MessageDigest md = MessageDigest.getInstance("MD5");
        final byte[] mD5digest = md.digest(bytesOfMessage);
        final StringBuilder hexStringBuilder = new StringBuilder();
        for (int i = 0; i < hexCharacters; i++) {
            hexStringBuilder.append(String.format("%02X", mD5digest[i]));
        }
        return hexStringBuilder.toString();
    }
}
