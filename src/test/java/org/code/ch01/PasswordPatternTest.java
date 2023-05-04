package org.code.ch01;

import static org.code.ch01.PasswordPattern.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PasswordPatternTest {

    /**
     * Method under test: {@link PasswordPattern#isPasswordComplex(String)}
     */

    @Test
    public void isPasswordComplex_true() {
        assertTrue(isPasswordComplex("Happy12"));
        assertTrue(isPasswordComplex("1WaeL ength"));
        assertTrue(isPasswordComplex("Password12"));
        assertTrue(isPasswordComplex("2PassW@ord1"));
        assertTrue(isPasswordComplex("01Sall#y9"));
    }

    @Test
    public void isPasswordComplex_false() {
        assertFalse(isPasswordComplex("12aB "));
        assertFalse(isPasswordComplex("Ab112"));
        assertFalse(isPasswordComplex("happy"));
        assertFalse(isPasswordComplex("happy_1"));
        assertFalse(isPasswordComplex("p assword12"));
        assertFalse(isPasswordComplex("Sur18"));
        assertFalse(isPasswordComplex(""));
    }

    /**
     * Method under test: {@link PasswordPattern#isPasswordComplexDeclarative(String)}
     */

    @Test
    public void isPasswordComplexDeclarative_true() {
        assertTrue(isPasswordComplexDeclarative("Happy12"));
        assertTrue(isPasswordComplexDeclarative("1WaeL ength"));
        assertTrue(isPasswordComplexDeclarative("Password12"));
        assertTrue(isPasswordComplexDeclarative("2PassW@ord1"));
        assertTrue(isPasswordComplexDeclarative("01Sall#y9"));
    }

    @Test
    public void isPasswordComplexDeclarative_false() {
        assertFalse(isPasswordComplexDeclarative("12aB "));
        assertFalse(isPasswordComplexDeclarative("Ab112"));
        assertFalse(isPasswordComplexDeclarative("happy"));
        assertFalse(isPasswordComplexDeclarative("happy_1"));
        assertFalse(isPasswordComplexDeclarative("p assword12"));
        assertFalse(isPasswordComplexDeclarative("Sur18"));
        assertFalse(isPasswordComplexDeclarative(""));
    }
}

