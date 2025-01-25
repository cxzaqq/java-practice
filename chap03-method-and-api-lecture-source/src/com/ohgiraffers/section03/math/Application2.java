package com.ohgiraffers.section03.math;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. 사용자 지정 범위의 난수를 발생시킬 수 있다. */

        // 0 ~ 9
        int rand1 = (int)(Math.random() * 10);
        System.out.println("rand1 = " + rand1);

        // 80 ~ 100
        int rand2 = (int)(Math.random() * 21) + 80;
        System.out.println("rand2 = " + rand2);

        // -188 ~ 10
        int rand3 = (int)(Math.random() * 199) - 188;
        System.out.println("rand3 = " + rand3);
    }
}
