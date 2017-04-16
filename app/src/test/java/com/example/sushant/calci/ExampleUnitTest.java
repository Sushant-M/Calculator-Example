package com.example.sushant.calci;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void our_addtion() throws Exception{
        Calculator calculator = new Calculator();
        int ans = calculator.add(5,6);
        assertEquals(11,ans);
    }
    @Test
    public void our_subtraction() throws Exception{
        Calculator calculator_1 = new Calculator() ;
        int ans_1 = calculator_1.sub(6,5);
        assertEquals(1,ans_1);
    }
}