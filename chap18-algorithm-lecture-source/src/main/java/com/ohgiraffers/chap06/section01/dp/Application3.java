package com.ohgiraffers.chap06.section01.dp;

public class Application3 {

    public static Integer[] dp = new Integer[101];

    public static int solution(int n) {
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        return padovan(n);
    }

    private static int padovan(int n) {
        if(dp[n] == null) dp[n] = padovan(n - 2) + padovan(n - 3);
        return dp[n];
    }
}
