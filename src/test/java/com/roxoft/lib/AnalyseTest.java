package com.roxoft.lib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnalyseTest {
    @Test
    public void creation(){
        assertNotNull(Analyse.string("first test"));
    }

    @Test
    public void startsWith(){
        assertTrue(Analyse.string("12345").startsWith(1,'1'));
        assertTrue(Analyse.string("11234").startsWith(2,'1'));
        assertTrue(Analyse.string("11123").startsWith(3,'1'));
        assertTrue(Analyse.string("11112").startsWith(4,'1'));
    }

    @Test
    public void moreReptitionsThanRequired(){
        assertTrue(Analyse.string("11234").startsWith(1,'1'));
        assertTrue(Analyse.string("11123").startsWith(2,'1'));
        assertTrue(Analyse.string("11112").startsWith(3,'1'));
    }

    @Test
    public void wrongCharacter(){
        assertFalse(Analyse.string("11112").startsWith(1,'2'));
        assertFalse(Analyse.string("11112").startsWith(2,'4'));
        assertFalse(Analyse.string("11112").startsWith(23,'6'));
    }

    @Test
    public void notEnoughRepetitions(){
        assertFalse(Analyse.string("11999").startsWith(3,'1'));
        assertFalse(Analyse.string("199999").startsWith(2,'1'));
        assertFalse(Analyse.string("1919191").startsWith(2,'1'));
        assertFalse(Analyse.string("1111111111").startsWith(11,'1'));
    }

    @Test
    public void zero(){
        /**
         * Is this what we want or do we want "0 repetitions of x to mean that it does NOT start with x"?
         */
        assertTrue(Analyse.string("19999").startsWith(0,'1'));
        assertTrue(Analyse.string("99999").startsWith(0,'1'));
    }
}
