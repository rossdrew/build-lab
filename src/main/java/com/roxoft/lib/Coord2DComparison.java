package com.roxoft.lib;

public final class Coord2DComparison {
    /** First comparison object. */
    private final IntegerCoord2D coordA;
    /** Second comparison object. */
    private final IntegerCoord2D coordB;

    private Coord2DComparison(final IntegerCoord2D first, final IntegerCoord2D second) {
        this.coordA = first;
        this.coordB = second;
    }

    /**
     * @param a The first {@link IntegerCoord2D} to be compared.
     * @param b The second {@link IntegerCoord2D} to be compared.
     * @return a new {@link Coord2DComparison} representing both {@link IntegerCoord2D} objects, ready to be compared.
     */
    public static Coord2DComparison with(final IntegerCoord2D a, final IntegerCoord2D b) {
        return new Coord2DComparison(a, b);
    }

    /**
     * @return the {@link Math#floor(double)}ed midpoint of two {@link IntegerCoord2D}.
     */
    public IntegerCoord2D midpoint() {
        final int averageX = (coordA.getX() + coordB.getX()) / 2;
        final int averageY = (coordA.getY() + coordB.getY()) / 2;

        return IntegerCoord2D.of(averageX, averageY);
    }
}
