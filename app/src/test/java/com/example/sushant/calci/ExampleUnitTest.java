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
        Calculator calculator = new Calculator() ;
        int answer = calculator.sub(6,5);
        assertEquals(1,answer);
    }
    @Test
    public void our_multiplication() throws Exception{
        Calculator calculator = new Calculator();
        int answer = calculator.mul(2,6);
        assertEquals(12,answer);
    }
    @Test
    public void our_div() throws Exception{
        Calculator calculator = new Calculator();
        int answer = calculator.div(6,2);
        assertEquals(3,answer);
    }
}