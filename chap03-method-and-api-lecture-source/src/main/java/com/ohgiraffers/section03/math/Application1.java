package com.ohgiraffers.section03.math;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. Math 클래스에서 제공하는 static 메서드를 호출할 수 있다 */

        double result = java.lang.Math.abs(-123);
        
        /* 설명. 다른 패키지에 있는 api 클래스는 import 또는 풀 클래스명을 써야 되지만 java.lang 패키지는 생략 가능 */
        double result2 = Math.abs(-123);
        System.out.println("result2 = " + result2);

        // 최대 최소
        System.out.println(Math.min(10, 20));
        System.out.println(Math.max(10, 20));

        // 난수 생성 0.00000... ~ 0.99999...
        System.out.println(Math.random());


    }
}
