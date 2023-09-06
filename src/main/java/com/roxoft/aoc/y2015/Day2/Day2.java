package com.roxoft.aoc.y2015.Day2;

import java.util.Objects;
import java.util.stream.Stream;

public final class Day2 {
    /** Length of box. */
    private final int l;
    /** Width of box. */
    private final int w;
    /** Height of box. */
    private final int h;

    /** Surface area of side A. */
    private final int sideA;
    /** Surface area of side B. */
    private final int sideB;
    /** Surface area of side C. */
    private final int sideC;

    private Day2(final int length,
                 final int width,
                 final int height) {
        l = length;
        w = width;
        h = height;

        sideA = (l * w);
        sideB = (w * h);
        sideC = (h * l);
    }

    /**
     * @param length of box.
     * @param width of box.
     * @param height of box.
     *
     * @return a {@link Day2} object based on a box with the specifications provided.
     */
    public static Day2 of(final int length,
                          final int width,
                          final int height) {
        return new Day2(length, width, height);
    }

    /**
     * @return surface area of the box.
     */
    public int getSurfaceArea() {
        return 2 * (sideA + sideB + sideC);
    }

    /**
     * @return the required wrapping paper in square feet {@link #getSurfaceArea()} with "a little extra".
     */
    public int getRequiredWrappingPaper() {
        return getSurfaceArea() + Stream.of(sideA, sideB, sideC).min(Integer::compare).get();
    }

    /**
     * @return the amount of ribbon needed to wrap the present in feet.
     */
    public int getRequiredRibbonToWrap() {
        return Stream.of(l, w, h)
                .mapToInt(i -> i)
                .sorted()
                .limit(2)
                .sum() * 2;
    }

    /**
     * @return the amount of ribbon required to make a bow in feet.
     */
    public int getRequiredRibbonToMakeBow() {
        return l * w * h;
    }

    /**
     * @return the required ribbon to wrap a present ({@link #getRequiredRibbonToWrap()}) and make a
     * bow ({@link #getRequiredRibbonToMakeBow()}).
     */
    public int getRequiredRibbon() {
        return getRequiredRibbonToWrap() + getRequiredRibbonToMakeBow();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Day2 day2 = (Day2) o;
        return l == day2.l && w == day2.w && h == day2.h;
    }

    @Override
    public int hashCode() {
        return Objects.hash(l, w, h);
    }
}
