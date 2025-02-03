package com.ohgiraffers.section03.abstraction;

import java.util.Scanner;

/* 설명.
 *  클래스
 *  1. 객체를 만들기 위한 도구이다.
 *  2. 하나의 새로운 사용자 정의형 타입
 *  3. 관련있는 속성과 기능의 묶음
 *  기능이 먼저 나온 후 속성이 추출되는 것임
 */

/* 설명. 
*   추상화란?
*   (객체들의)공통된 부분을 추출하고 공통되지 않고 불필요한 부분을 제거한다는 의미를 가지며 추상화의 목적은
*   (객체들의)유연성을 확보하기 위함이다.
*   유연성 확보는 여러 곳에서 적용될 수 있는 유연한 객체를 의미하며 재사용성이 높아질 수 있게 한다는 의미이다.
*   (우리는 자연스럽게 추상화를 이루었지만 그렇게 추상화된 클래스로 유연한 객체들을 생성할 수 있다.
* 
*  설명.
*   1. 협력(객체간의 필요한 의사소통())
*   2. 책임(객체가 가진 기능들(메소드들))
*   3. 역할(기능들(메소드들)이 모이면 역할)
* */

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
