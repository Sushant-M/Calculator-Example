package com.example.sushant.calci;

/**
 * Created by sushant on 16/4/17.
 */

public class Calculator {

    public int add(int x, int y){
        return x+y;
    }

    public int mul(int x, int y){
        return x*y;
    }

    public int div(int x, int y) throws ArithmeticException{
        try{
            return x/y;
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
        return 0;
    }

    public int sub(int x, int y){
        return x-y;
    }

}
