package com.roxoft.test.com.roxoft.aoc.y2015;

import com.roxoft.test.com.roxoft.aoc.UnexpectedSolutionException;

import java.util.Arrays;
import java.util.List;

public final class Day1 {
    /** Compiled department store directions for Santa. */
    private final List<Integer> numericalDirections;

    private Day1(final String directionsForSanta) {
        this.numericalDirections = Arrays.stream(directionsForSanta.split("")).map(i -> switch (i) {
            case "(" -> 1;
            case ")" -> -1;
            default -> 0;
        }).toList();
    }

    /**
     * @param directions for Santa to follow
     * @return a {@link Day1} solutions class for the given directions.
     */
    public static Day1 of(final String directions) {
        return new Day1(directions);
    }

    /**
     * @return Santas final location after following all instructions.
     */
    public int finalLocation() {
        return numericalDirections.stream().mapToInt(i -> i).sum();
    }

    /**
     * @return the step in the given directions where Santa first enters the basement.
     */
    public int firstBasementVisit() {
        for (int step = 0, location = 0; step < numericalDirections.size(); step++) {
            location += numericalDirections.get(step);
            if (location == -1) {
                return (step + 1);
            }
        }

        throw new UnexpectedSolutionException("Basement never reached!");
    }
}
