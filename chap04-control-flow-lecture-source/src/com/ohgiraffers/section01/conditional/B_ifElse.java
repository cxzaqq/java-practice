package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class B_ifElse {
    public void testSimpleElseStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.println("정수를 입력하세요");
        int input = sc.nextInt();

        if (input % 2 != 0) {
            System.out.println("홀수");
        } else {
            System.out.println("짝수");
        }
        
        sc.close();
    }

    public void testNestedIfElseStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.println("정수 입력: ");
        int input = sc.nextInt();
        if (input >= 0) {
            if(input % 2 == 0) {
                System.out.println("양수, 짝수");
            } else {
                System.out.println("양수, 홀수");
            }
        } else {
            System.out.println("음수");
        }
    }
}
