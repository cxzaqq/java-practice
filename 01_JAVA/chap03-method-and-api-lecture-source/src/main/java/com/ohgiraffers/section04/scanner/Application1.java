package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. java.util.Scanner를 이용해 다양한 자료형의 값 입력 받기 */
        // non-static method
        Scanner sc = new Scanner(System.in);

        /* 설명. 0. next()를 활용한 콘솔에서의 문자열 입력 */
        System.out.print("소속을 입력하세요: ");
        String className = sc.next();
        System.out.println("className = " + className);
        /* 소속에 "14기" 입력 시 버퍼는 14기만 가져가고 엔터는 남음 */
        
        sc.nextLine();          // 버퍼에 있는 엔터 제거용

        /* 설명. 1. nextLine()을 활용한 콘솔에서의 문자열 입력 */
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.println("name: " + name);
        /* 버퍼가 엔터가 남아있기에 입력을 받았다고 인지함 */

        /* 설명. 2. nextInt()를 활용한 정수 입력 */
        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();
        System.out.println("age = " + age);

        /* 설명. 3. nextDouble()을 활용한 실수 입력 */
        System.out.print("키를 입력하세요: ");
        double height = sc.nextDouble();
        System.out.println("height = " + height);
    }
}
