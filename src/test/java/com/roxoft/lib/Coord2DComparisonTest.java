package com.roxoft.lib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Coord2DComparisonTest{
    @Test
    public void testSimpleMidpointCalculation(){
        final Coord2D a = Coord2D.of(1,1);
        final Coord2D b = Coord2D.of(3,3);

        final Coord2DComparison comparison = Coord2DComparison.with(a, b);

        assertEquals(Coord2D.of(2,2), comparison.midpoint());
    }

    @Test
    public void nonIntegerMidpointCalculationResult(){
        final Coord2D a = Coord2D.of(3,5);
        final Coord2D b = Coord2D.of(6,3);

        final Coord2DComparison comparison = Coord2DComparison.with(a, b);

        assertEquals(Coord2D.of(4,4), comparison.midpoint());
    }
}
