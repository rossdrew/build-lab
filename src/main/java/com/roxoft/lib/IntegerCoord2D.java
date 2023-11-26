package com.roxoft.lib;

import java.util.Objects;

public final class IntegerCoord2D {
    /** Cartesian x co-ordinate of location. */
    private final int xCoordinate;
    /** Cartesian y co-ordinate of location. */
    private final int yCoordinate;

    private IntegerCoord2D(final int x,
                           final int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    /**
     * @param x Cartesian x co-ordinate of a 2D location.
     * @param y Cartesian y co-ordinate of a 2D location.
     * @return a {@link IntegerCoord2D} representation of x and y
     */
    public static IntegerCoord2D of(final int x, final int y) {
        return new IntegerCoord2D(x, y);
    }

    /**
     * @return Cartesian x co-ordinate of location.
     */
    public int getX() {
        return xCoordinate;
    }

    /**
     * @return Cartesian x co-ordinate of location.
     */
    public int getY() {
        return yCoordinate;
    }

    @Override
    public String toString() {
        return "Loc ("
                + xCoordinate
                + ", "
                + yCoordinate
                + ")";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IntegerCoord2D coord2D = (IntegerCoord2D) o;
        return xCoordinate == coord2D.xCoordinate && yCoordinate == coord2D.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
