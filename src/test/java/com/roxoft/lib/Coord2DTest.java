package com.roxoft.lib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Coord2DTest {
    @Test
    public void create(){
        final Coord2D coords = Coord2D.of(0,0);
        assertEquals(0, coords.getX());
        assertEquals(0, coords.getY());
    }

    @Test
    public void toStringTest(){
        assertEquals("Loc (0, 0)", Coord2D.of(0, 0).toString());
        assertEquals("Loc (12, 0)", Coord2D.of(12, 0).toString());
        assertEquals("Loc (123, 23)", Coord2D.of(123, 23).toString());
    }

    @Test
    public void equalsTest(){
        final Coord2D staticCoords = Coord2D.of(0,0);

        assertEquals(staticCoords, staticCoords);

        assertEquals(Coord2D.of(50,50), Coord2D.of(50,50));

        assertNotEquals(Coord2D.of(51,50), Coord2D.of(50,50));
        assertNotEquals(Coord2D.of(50,51), Coord2D.of(50,50));
        assertNotEquals(Coord2D.of(50,50), Coord2D.of(51,50));
        assertNotEquals(Coord2D.of(50,50), Coord2D.of(50,51));
        assertNotEquals(Coord2D.of(51,50), Coord2D.of(50,51));

        assertNotEquals(Coord2D.of(99,12), "This is not even a coord");
        assertNotEquals(Coord2D.of(99,12), null);
    }

    @Test
    public void hashCodeTest(){
        final Coord2D staticCoords = Coord2D.of(0,0);

        assertEquals(staticCoords.hashCode(), staticCoords.hashCode());

        assertEquals(Coord2D.of(50,50).hashCode(), Coord2D.of(50,50).hashCode());

        assertNotEquals(Coord2D.of(51,50).hashCode(), Coord2D.of(50,50).hashCode());
        assertNotEquals(Coord2D.of(50,51).hashCode(), Coord2D.of(50,50).hashCode());
        assertNotEquals(Coord2D.of(50,50).hashCode(), Coord2D.of(51,50).hashCode());
        assertNotEquals(Coord2D.of(50,50).hashCode(), Coord2D.of(50,51).hashCode());
        assertNotEquals(Coord2D.of(51,50).hashCode(), Coord2D.of(50,51).hashCode());
    }
}
