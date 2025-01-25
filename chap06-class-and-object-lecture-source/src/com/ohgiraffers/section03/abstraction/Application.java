package com.ohgiraffers.section03.abstraction;

import java.util.Scanner;

/* 설명.
 *  클래스
 *  1. 객체를 만들기 위한 도구이다.
 *  2. 하나의 새로운 사용자 정의형 타입
 *  3. 관련있는 속성과 기능의 묶음
 *  기능이 먼저 나온 후 속성이 추출되는 것임
 */

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CarRacer racer = new CarRacer();  // 차 한 대를 소유한 카레이서 등장

        int input = 0;
        do {
            System.out.println("===== 카레이싱 프로그램 =====");
            System.out.println("1. 시동 걸기");
            System.out.println("2. 전진");
            System.out.println("3. 정지");
            System.out.println("4. 시동 끄기");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 선택: ");
            input = sc.nextInt();
            switch (input) {
                case 1: racer.startUp();
                    break;
                case 2: racer.stepAccelerator();
                    break;
                case 3: racer.stepBreak();
                    break;
                case 4: racer.turnOff();
                    break;
                case 9:
                    System.out.println("감사합니다. 또 오세요");
                    break;
                default:
                    System.out.println("잘못된 메뉴를 선택했습니다.");
                    break;

            }
        } while(input != 9);
    }
}
