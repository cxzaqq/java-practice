package com.ohgiraffers.chap04.section01.greedy;

public class Application1 {
    public static int solution(int n) {

        /* 설명. 5Kg or 3Kg 봉지로 가져갈 수 있는 최소 봉지 수 */
        int count = 0;

        while(true) {
            if(n % 5 == 0) {
                return n / 5 + count;
            } else {
                n -= 3;
                count++;

                if(n == 0) break;
                if(n < 0) return -1;
            }
        }

        return count;
    }
}
