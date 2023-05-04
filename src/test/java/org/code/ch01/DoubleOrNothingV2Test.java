package org.code.ch01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DoubleOrNothingV2Test {

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link DoubleOrNothingV2}
     *   <li>{@link DoubleOrNothingV2#getIsStillPlaying()}
     * </ul>
     */

    private final ByteArrayOutputStream gamePrintOut = new ByteArrayOutputStream();

    @Test
    public void testConstructor() {
        assertTrue((new DoubleOrNothingV2()).getIsStillPlaying());
    }


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(gamePrintOut));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }


    @Test
    public void askUserToContinue_YES() {

        String input = "yes";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        DoubleOrNothingV2 game = new DoubleOrNothingV2();
        assertTrue(game.getIsStillPlaying());

        game.askUserToContinue();
        assertTrue(game.getIsStillPlaying());
    }

    @Test
    public void askUserToContinue_NO() {
        String input = "no";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        DoubleOrNothingV2 game = new DoubleOrNothingV2();
        assertTrue(game.getIsStillPlaying());

        game.askUserToContinue();
        assertFalse(game.getIsStillPlaying());
    }
}

