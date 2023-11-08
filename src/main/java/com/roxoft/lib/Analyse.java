package com.roxoft.lib;

import java.util.List;

public class Analyse {
    private final String value;

    private Analyse(final String input){
        this.value = input;
    }

    public static Analyse string(final String input){
        return new Analyse(input);
    }

    public boolean startsWith(final int numberOf, final char characters){
        if (value.length() < numberOf)
            return false;

        final List<Character> list = value.substring(0, numberOf).chars().mapToObj(c -> (char) c).distinct().toList();
        if (list.size() > 1)
            return false;

        return list.get(0) == characters;
    }
}
