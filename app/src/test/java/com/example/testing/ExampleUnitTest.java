package com.example.testing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Calculator calculator;
    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void add() throws Exception{
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void sub() throws Exception{
        assertEquals(10, calculator.subtract(12,2));
    }

    @Test
    public void div() throws Exception{
        assertEquals(4, calculator.divide(16, 4));
        assertEquals(0, calculator.divide(10, 0));
    }

    @Test
    public void mul() throws Exception{
        assertEquals(25, calculator.multiply(5, 5));
    }


}