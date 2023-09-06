package com.roxoft.aoc.y2015.Day2;

import java.util.Arrays;
import java.util.List;

public final class Parser {
    /** The raw content to be parsed. */
    private final String content;

    private Parser(final String stringToParse) {
        this.content = stringToParse;
    }

    /**
     * @param stringToParse the string intended to be parsed.
     * @return A {@link Parser} ready to parse the input.
     */
    public static Parser parsing(final String stringToParse) {
        return new Parser(stringToParse);
    }

    /**
     * @return {@link Day2} object from the raw string.
     */
    public Day2 asDay2Entry() {
        //^[0-9]{1,2}x[0-9]{1,2}x[0-9]{1,2}$
        final List<Integer> x = Arrays
                .stream(content.split("x"))
                .map(Integer::parseInt)
                .toList();
        return Day2.of(x.get(0), x.get(1), x.get(2));
    }
}
