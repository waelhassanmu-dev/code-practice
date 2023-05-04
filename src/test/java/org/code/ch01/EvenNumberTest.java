package org.code.ch01;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EvenNumberTest {

    /**
     * Method under test: {@link EvenNumber#isEven(int)}
     */
    @Test
    public void isEven_true() {
        assertTrue(EvenNumber.isEven(0));
        assertTrue(EvenNumber.isEven(2));
        assertTrue(EvenNumber.isEven(4));
        assertTrue(EvenNumber.isEven(6));
        assertTrue(EvenNumber.isEven(8));
        assertTrue(EvenNumber.isEven(-20));
        assertTrue(EvenNumber.isEven(100));
        assertTrue(EvenNumber.isEven(-46));
    }

    @Test
    public void isEven_false() {
        assertFalse(EvenNumber.isEven(1));
        assertFalse(EvenNumber.isEven(3));
        assertFalse(EvenNumber.isEven(5));
        assertFalse(EvenNumber.isEven(7));
        assertFalse(EvenNumber.isEven(9));
        assertFalse(EvenNumber.isEven(-11));
        assertFalse(EvenNumber.isEven(93));
        assertFalse(EvenNumber.isEven(-75));
    }
}

