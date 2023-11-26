package com.roxoft.lib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class IntegerCoord2DTest {
    @Test
    public void create(){
        final IntegerCoord2D coords = IntegerCoord2D.of(0,0);
        assertEquals(0, coords.getX());
        assertEquals(0, coords.getY());
    }

    @Test
    public void toStringTest(){
        assertEquals("Loc (0, 0)", IntegerCoord2D.of(0, 0).toString());
        assertEquals("Loc (12, 0)", IntegerCoord2D.of(12, 0).toString());
        assertEquals("Loc (123, 23)", IntegerCoord2D.of(123, 23).toString());
    }

    @Test
    public void equalsTest(){
        final IntegerCoord2D staticCoords = IntegerCoord2D.of(0,0);

        assertEquals(staticCoords, staticCoords);

        assertEquals(IntegerCoord2D.of(50,50), IntegerCoord2D.of(50,50));

        assertNotEquals(IntegerCoord2D.of(51,50), IntegerCoord2D.of(50,50));
        assertNotEquals(IntegerCoord2D.of(50,51), IntegerCoord2D.of(50,50));
        assertNotEquals(IntegerCoord2D.of(50,50), IntegerCoord2D.of(51,50));
        assertNotEquals(IntegerCoord2D.of(50,50), IntegerCoord2D.of(50,51));
        assertNotEquals(IntegerCoord2D.of(51,50), IntegerCoord2D.of(50,51));

        assertNotEquals(IntegerCoord2D.of(99,12), "This is not even a coord");
        assertNotEquals(IntegerCoord2D.of(99,12), null);
    }

    @Test
    public void hashCodeTest(){
        final IntegerCoord2D staticCoords = IntegerCoord2D.of(0,0);

        assertEquals(staticCoords.hashCode(), staticCoords.hashCode());

        assertEquals(IntegerCoord2D.of(50,50).hashCode(), IntegerCoord2D.of(50,50).hashCode());

        assertNotEquals(IntegerCoord2D.of(51,50).hashCode(), IntegerCoord2D.of(50,50).hashCode());
        assertNotEquals(IntegerCoord2D.of(50,51).hashCode(), IntegerCoord2D.of(50,50).hashCode());
        assertNotEquals(IntegerCoord2D.of(50,50).hashCode(), IntegerCoord2D.of(51,50).hashCode());
        assertNotEquals(IntegerCoord2D.of(50,50).hashCode(), IntegerCoord2D.of(50,51).hashCode());
        assertNotEquals(IntegerCoord2D.of(51,50).hashCode(), IntegerCoord2D.of(50,51).hashCode());
    }
}
