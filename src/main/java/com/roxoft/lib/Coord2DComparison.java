package com.roxoft.lib;

public final class Coord2DComparison {
    /** First comparison object. */
    private final Coord2D coordA;
    /** Second comparison object. */
    private final Coord2D coordB;

    private Coord2DComparison(final Coord2D first, final Coord2D second) {
        this.coordA = first;
        this.coordB = second;
    }

    /**
     * @param a The first {@link Coord2D} to be compared.
     * @param b The second {@link Coord2D} to be compared.
     * @return a new {@link Coord2DComparison} representing both {@link Coord2D} objects, ready to be compared.
     */
    public static Coord2DComparison with(final Coord2D a, final Coord2D b) {
        return new Coord2DComparison(a, b);
    }

    /**
     * @return the {@link Math#floor(double)}ed midpoint of two {@link Coord2D}.
     */
    public Coord2D midpoint() {
        final int averageX = (coordA.getX() + coordB.getX()) / 2;
        final int averageY = (coordA.getY() + coordB.getY()) / 2;

        return Coord2D.of(averageX, averageY);
    }
}
