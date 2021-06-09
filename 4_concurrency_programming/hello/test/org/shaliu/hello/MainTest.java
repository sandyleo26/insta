package org.shaliu.hello;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    private int [] A = {1, 0, 3}; // 1*1, 3*3
    private int [] B = {1, 0, 0, 0, 0, 0, 0, 0, 0, 1}; // 1*1, 10*1
    private int [] C = {0, 1, 0, 0, 5, 0, 0, 0, 1, 0}; // 2*1, 5*5, 9*1
    private int [] D = {0};
    private int [] E = {};
    @Test
    public void testGetAverage() {
        assertEquals((1+3*3)/4.0, Main.getAverage(A), 1e-6);
        assertEquals((1+10)/2.0, Main.getAverage(B), 1e-6);
        assertEquals((2+25+9)/7.0, Main.getAverage(C), 1e-6);
        assertEquals(0, Main.getAverage(E), 1e-6);
    }

    @Test
    public void testGetMin() {
        assertEquals(1, Main.getMin(A));
        assertEquals(2, Main.getMin(C));
        assertEquals(-1, Main.getMin(D));
        assertEquals(-1, Main.getMin(E));
    }

    @Test
    public void testGetMax() {
        assertEquals(3, Main.getMax(A));
        assertEquals(10, Main.getMax(B));
        assertEquals(9, Main.getMax(C));
        assertEquals(Integer.MAX_VALUE, Main.getMax(D));
        assertEquals(Integer.MAX_VALUE, Main.getMax(E));
    }

    @Test
    public void testGetMostFrequent() {
        assertEquals(3, Main.getMostFrequent(A));
        assertEquals(1, Main.getMostFrequent(B));
        assertEquals(5, Main.getMostFrequent(C));
        assertEquals(-1, Main.getMostFrequent(D));
        assertEquals(-1, Main.getMostFrequent(E));
    }
}