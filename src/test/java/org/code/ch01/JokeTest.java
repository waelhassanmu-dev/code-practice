package org.code.ch01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.Assert.*;

public class JokeTest {
    /**
     * Method under test: {@link Joke#parseJoke(String)}
     */
    private static final String JOKE = "Knock knock!";

    private final ByteArrayOutputStream printOut = new ByteArrayOutputStream();

    @Before
    public void setUpEach() {
        System.setOut(new PrintStream(printOut));
    }

    @After
    public void cleanUpEach() {
        System.setOut(System.out);
    }

    @Test
    public void parseJoke() {
        Optional<String> jokeOpt = Joke.parseJoke("{\"id\":\"abc\",\"status\":200,\"joke\":\"" + JOKE + "\"}");
        assertTrue(jokeOpt.isPresent());
        assertEquals(JOKE, jokeOpt.get());
    }

    @Test
    public void parseJoke_noJokes() {

        Optional<String> jokeOpt = Joke.parseJoke("[]");
        assertFalse(jokeOpt.isPresent());
    }
}

