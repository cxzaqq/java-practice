package com.ohgiraffers.section02.package_and_import;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 패키지에 대해 이해할 수 있다. */
        /* 설명.
         *  패키지의 의미
         *  1. 클래스의 소속
         *  2. 원래는 클래스명의 일부분인다
         *  3. 경우에 따라 생략 가능하다.
        *  */
        
        /* 설명. 다른 패키지에 있는 non-static 메소드를 가져오기 위해 선언  */
        com.ohgiraffers.section01.method.Calculator cal = new com.ohgiraffers.section01.method.Calculator();

        int plusResult = cal.plusTwoNumbers(1, 2);
        System.out.println("plusResult = " + plusResult);
        
        /* 설명. 다른 패키지에 있는 static 메소드를 가져오기 위해 선언 */
        int minResult = com.ohgiraffers.section01.method.Calculator.minNumbersOf(1, 2);
        // 이렇게 길게 쓰면 힘드니까 import로 짧게 쓸 수 있다.


    }
}
