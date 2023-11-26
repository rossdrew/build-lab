package com.roxoft.lib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerCoord2DComparisonTest {
    @Test
    public void testSimpleMidpointCalculation(){
        final IntegerCoord2D a = IntegerCoord2D.of(1,1);
        final IntegerCoord2D b = IntegerCoord2D.of(3,3);

        final Coord2DComparison comparison = Coord2DComparison.with(a, b);

        assertEquals(IntegerCoord2D.of(2,2), comparison.midpoint());
    }

    @Test
    public void nonIntegerMidpointCalculationResult(){
        final IntegerCoord2D a = IntegerCoord2D.of(3,5);
        final IntegerCoord2D b = IntegerCoord2D.of(6,3);

        final Coord2DComparison comparison = Coord2DComparison.with(a, b);

        assertEquals(IntegerCoord2D.of(4,4), comparison.midpoint());
    }
}
