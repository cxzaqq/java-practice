package com.ohgiraffers.section01.looping;

import java.util.Scanner;

public class B_nestedFor {
    public void printGugudanFromTwoToNine() {

        /* 설명.
         *  2단
         *   2 * 1 = 2
         *   2 * 2 = 4
         *   ...
         *  9단
         *   9 * 1 = 9
         *   9 * 2 = 18
         *   ...
         *   9 * 9 = 81
         * */
//        for (int dan = 2; dan <= 9; dan++) {
//            System.out.println(dan + "단");
//            for (int su = 1; su <= 9; su++) {
//                System.out.println(dan + " * " + su + " = " + (dan * su));
//            }
//            System.out.println();
//        }

        for (int dan = 2; dan <= 9; dan++) {
            System.out.println(dan + "단");
            printGugudanOf(dan);
            System.out.println();
        }
    }

    /* 설명. dan을 넘겨주면 해당 단수의 구구단을 출력하는 메소드 */
    private void printGugudanOf(int dan) {
        for (int su = 1; su <= 9; su++) {
            System.out.println(dan + " * " + su + " = " + (dan * su));
        }
    }

    public void printStar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 입력");
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            /* 설명. 공백 찍기 */
            printSpace(input, i);
            /* 설명. 별 찍기 */
            printStar(i);
            System.out.println();
        }
    }
    // 이미 위 함수를 다른 곳에서 실행하려면 이미 이 클래스가 밝혀진 것이기에 static이 필요 없음
    private void printStar(int i) {
        for (int j = 0; j < i + 1; j++) {
            System.out.print("*");
        }
    }
    private void printSpace(int input, int i) {
        for (int j = 0; j < input - (i + 1); j++) {
            System.out.print(" ");
        }
    }
}
