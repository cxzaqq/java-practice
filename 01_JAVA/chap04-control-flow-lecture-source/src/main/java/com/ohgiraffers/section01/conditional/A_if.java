package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class A_if {

    public void testSimpleIfStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.println("정수 한 개를 입력하세요: ");
        int input = sc.nextInt();

        if (input % 2 == 0) {
            System.out.println("짝수입니다.");
        }

        sc.close();
    }

    public void testNestedIfStatement() {
        Scanner sc = new Scanner(System.in);

        System.out.println("양수 하나를 입력해 주세요: ");
        int input = sc.nextInt();
        if (input > 0) {
            if(input % 2 == 0) {
                System.out.println("양수이면서 짝수입니다.");
            }
        }

        if (input > 0 && input % 2 == 0) {
            System.out.println("양수이면서 짝수입니다.");
        }


    }
}
