package com.roxoft.aoc.y2015.Day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ParserTest {
    @Test
    public void requirement_day2_threeDimensions(){
        assertEquals(Day2.of(1,1,1), Parser.parsing("1x1x1").asDay2Entry());
        assertEquals(Day2.of(2,5,9), Parser.parsing("2x5x9").asDay2Entry());
        assertEquals(Day2.of(9,9,9), Parser.parsing("9x9x9").asDay2Entry());

        assertEquals(Day2.of(1,99,40), Parser.parsing("1x99x40").asDay2Entry());

        assertNotEquals(Day2.of(1,9,9), Parser.parsing("9x9x9").asDay2Entry());
        assertNotEquals(Day2.of(9,1,9), Parser.parsing("9x9x9").asDay2Entry());
        assertNotEquals(Day2.of(9,9,1), Parser.parsing("9x9x9").asDay2Entry());

        assertNotEquals(Day2.of(9,9,9), Parser.parsing("9x9x1").asDay2Entry());
        assertNotEquals(Day2.of(9,9,9), Parser.parsing("9x1x9").asDay2Entry());
        assertNotEquals(Day2.of(9,9,9), Parser.parsing("1x9x9").asDay2Entry());
    }

}
