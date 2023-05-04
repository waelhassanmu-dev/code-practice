package org.code.ch01;

import static org.code.ch01.BillCalculator.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BillCalculatorTest {

    /**
     * Method under test: {@link BillCalculator#calculateBill(double)}
     */
    @Test
    public void testCalculateBill() {

        assertEquals(18.84d, calculateBill(10.0d), 0.0);
        assertEquals(18.84d, calculateBill(Double.NaN), 0.0);

        assertEquals(22.74d, calculateBill(1800), 0);
        assertEquals(22.74d, calculateBill(2244), 0);
        assertEquals(26.64d, calculateBill(2245), 0);
        assertEquals(26.64d, calculateBill(2992), 0);
        assertEquals(46.14d, calculateBill(6000), 0);
        assertEquals(53.94d, calculateBill(8000), 0);

        assertEquals(18.84d, calculateBill(0), 0);
        assertEquals(18.84d, calculateBill(1496), 0);
        assertEquals(22.74d, calculateBill(1497), 0);
        assertEquals(18.84d, calculateBill(-20), 0);
    }

    /**
     * Method under test: {@link BillCalculator#calculateBillUsingMath(double)}
     */
    @Test
    public void testCalculateBillUsingMath() {

        assertEquals(18.84d, calculateBillUsingMath(10.0d), 0.0);
        assertEquals(22.74d, calculateBillUsingMath(1800), 0);
        assertEquals(22.74d, calculateBillUsingMath(2244), 0);
        assertEquals(26.64d, calculateBillUsingMath(2245), 0);
        assertEquals(26.64d, calculateBillUsingMath(2992), 0);
        assertEquals(46.14d, calculateBillUsingMath(6000), 0);
        assertEquals(53.94d, calculateBillUsingMath(8000), 0);

        assertEquals(18.84d, calculateBillUsingMath(0), 0);
        assertEquals(18.84d, calculateBillUsingMath(1496), 0);
        assertEquals(22.74d, calculateBillUsingMath(1497), 0);
        assertEquals(18.84d, calculateBillUsingMath(-20), 0);
    }
}

