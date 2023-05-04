package org.code.ch01;

import static org.code.ch01.EvenNumber.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EvenNumberTest {

    /**
     * Method under test: {@link EvenNumber#isEven(int)}
     */
    @Test
    public void isEven_true() {
        assertTrue(isEven(0));
        assertTrue(isEven(2));
        assertTrue(isEven(4));
        assertTrue(isEven(6));
        assertTrue(isEven(8));
        assertTrue(isEven(-20));
        assertTrue(isEven(100));
        assertTrue(isEven(-46));
    }

    @Test
    public void isEven_false() {
        assertFalse(isEven(1));
        assertFalse(isEven(3));
        assertFalse(isEven(5));
        assertFalse(isEven(7));
        assertFalse(isEven(9));
        assertFalse(isEven(-11));
        assertFalse(isEven(93));
        assertFalse(isEven(-75));
    }

    /**
     * Method under test: {@link EvenNumber#isEvenBitwise(int)}
     */
    @Test
    public void isEvenBitwise_true() {
        assertTrue(isEvenBitwise(0));
        assertTrue(isEvenBitwise(2));
        assertTrue(isEvenBitwise(4));
        assertTrue(isEvenBitwise(6));
        assertTrue(isEvenBitwise(8));
        assertTrue(isEvenBitwise(-20));
        assertTrue(isEvenBitwise(100));
        assertTrue(isEvenBitwise(-46));
    }

    @Test
    public void isEvenBitwise_false() {
        assertFalse(isEvenBitwise(1));
        assertFalse(isEvenBitwise(3));
        assertFalse(isEvenBitwise(5));
        assertFalse(isEvenBitwise(7));
        assertFalse(isEvenBitwise(9));
        assertFalse(isEvenBitwise(-11));
        assertFalse(isEvenBitwise(93));
        assertFalse(isEvenBitwise(-75));
    }
}

