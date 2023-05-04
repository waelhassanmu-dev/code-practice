package org.code.ch01;

import static org.code.ch01.BillCalculator.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BillCalculatorTest {

    /**
     * Method under test: {@link BillCalculator#calculateWaterBill(double)}
     */
    @Test
    public void testCalculateWaterBill() {

        assertEquals(18.84d, calculateWaterBill(10.0d), 0.0);
        assertEquals(18.84d, calculateWaterBill(Double.NaN), 0.0);

        assertEquals(22.74d, calculateWaterBill(1800), 0);
        assertEquals(22.74d, calculateWaterBill(2244), 0);
        assertEquals(26.64d, calculateWaterBill(2245), 0);
        assertEquals(26.64d, calculateWaterBill(2992), 0);
        assertEquals(46.14d, calculateWaterBill(6000), 0);
        assertEquals(53.94d, calculateWaterBill(8000), 0);

        assertEquals(18.84d, calculateWaterBill(0), 0);
        assertEquals(18.84d, calculateWaterBill(1496), 0);
        assertEquals(22.74d, calculateWaterBill(1497), 0);
        assertEquals(18.84d, calculateWaterBill(-20), 0);
    }
}

