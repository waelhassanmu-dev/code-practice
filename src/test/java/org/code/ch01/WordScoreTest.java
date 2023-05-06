package org.code.ch01;

import static org.code.ch01.WordScore.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordScoreTest {
    /**
     * Method under test: {@link WordScore#wordScoreCalculator(String)}
     */
    @Test
    public void testWordScoreCalculator() {
        assertEquals(8, wordScoreCalculator("Word"));
        assertEquals(10, wordScoreCalculator("very"));
        assertEquals(12, wordScoreCalculator("zoo"));
        assertEquals(28, wordScoreCalculator("maximize"));
        assertEquals(17, wordScoreCalculator("exercise"));
        assertEquals(27, wordScoreCalculator("jukebox"));
        assertEquals(26, wordScoreCalculator("flapjack"));
        assertEquals(25, wordScoreCalculator("squeeze"));
        assertEquals(11, wordScoreCalculator("school"));
        assertEquals(9, wordScoreCalculator("ex"));
        assertEquals(12, wordScoreCalculator("common"));
    }

    @Test
    public void testWordScoreCalculator_edgeCases() {
        assertEquals(0, wordScoreCalculator(""));
        assertEquals(0, wordScoreCalculator("          "));
        assertEquals(0, wordScoreCalculator("     12-183     "));
        assertEquals(10, wordScoreCalculator("v2ery"));
        assertEquals(10, wordScoreCalculator("Very"));
        assertEquals(10, wordScoreCalculator("VeRy"));
        assertEquals(10, wordScoreCalculator("VERY"));
        assertEquals(10, wordScoreCalculator("ver!y"));
        assertEquals(10, wordScoreCalculator("ver!y"));
        assertEquals(10, wordScoreCalculator("  ve ry"));
        assertEquals(10, wordScoreCalculator("  ve ry"));
        assertEquals(7, wordScoreCalculator("dadd"));
    }
}

