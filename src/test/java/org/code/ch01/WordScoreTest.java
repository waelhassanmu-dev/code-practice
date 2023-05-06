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

    /**
     * Method under test: {@link WordScore#wordScoreCalculatorV2(String)}
     */
    @Test
    public void testWordScoreCalculatorV2() {
        assertEquals(8, wordScoreCalculatorV2("Word"));
        assertEquals(10, wordScoreCalculatorV2("very"));
        assertEquals(12, wordScoreCalculatorV2("zoo"));
        assertEquals(28, wordScoreCalculatorV2("maximize"));
        assertEquals(17, wordScoreCalculatorV2("exercise"));
        assertEquals(27, wordScoreCalculatorV2("jukebox"));
        assertEquals(26, wordScoreCalculatorV2("flapjack"));
        assertEquals(25, wordScoreCalculatorV2("squeeze"));
        assertEquals(11, wordScoreCalculatorV2("school"));
        assertEquals(9, wordScoreCalculatorV2("ex"));
        assertEquals(12, wordScoreCalculatorV2("common"));
    }

    @Test
    public void testWordScoreCalculatorV2_edgeCases() {
        assertEquals(0, wordScoreCalculatorV2(""));
        assertEquals(0, wordScoreCalculatorV2("          "));
        assertEquals(0, wordScoreCalculatorV2("     12-183     "));
        assertEquals(10, wordScoreCalculatorV2("v2ery"));
        assertEquals(10, wordScoreCalculatorV2("Very"));
        assertEquals(10, wordScoreCalculatorV2("VeRy"));
        assertEquals(10, wordScoreCalculatorV2("VERY"));
        assertEquals(10, wordScoreCalculatorV2("ver!y"));
        assertEquals(10, wordScoreCalculatorV2("ver!y"));
        assertEquals(10, wordScoreCalculatorV2("  ve ry"));
        assertEquals(10, wordScoreCalculatorV2("  ve ry"));
        assertEquals(7, wordScoreCalculatorV2("dadd"));
    }
}

