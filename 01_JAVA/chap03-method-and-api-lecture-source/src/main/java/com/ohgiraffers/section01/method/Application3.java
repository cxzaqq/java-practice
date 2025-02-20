package com.ohgiraffers.section01.method;

public class Application3 {
    static int GLOBAL = 10;                                     // 전역 변수(모든 메소드에서 사용 가능)
    public static void main(String[] args) {
        /* 수업목표. 1. 메소드 전달인자(arguments)와 매개변수(parameter)에 대해 이해하고 메소드 호출 시 활용할 수 있다. */
        /* 수업목표. 2. 전역, 지역 변수를 이해하고 활용할 수 있다. */

        Application3 app3 = new Application3();
        app3.testMethod(13);                                // 여기서 13이 arguemt
    }

    public void testMethod(int age) {                           // 여기서 age가 parameter
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }

    public void testMethod2() {
        int local = 20;                                         // 지역 변수(해당 메소드 외에 사용 불가)
    }
}
