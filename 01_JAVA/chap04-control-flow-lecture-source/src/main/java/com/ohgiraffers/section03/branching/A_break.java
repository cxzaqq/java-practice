package com.ohgiraffers.section03.branching;

public class A_break {
    public static void testSimpleBreakStatement() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
            System.out.println("sum = " + sum);

            if(i == 3) break;
        }
    }
}
