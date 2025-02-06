package com.ohgiraffers.section01.exception;

public class Application {
    /* 설명. main에서 throws 쓰면 JVM한테 예외를 넘기는 것 */
    public static void main(String[] args) /*throws ArithmeticException*/ {

        /* 수업목표. 예외에 대해 이해하고 이를 처리하기 위한 문법을 활용할 수 있다.
        *  설명.
        *   1. throws를 통한 위임
        *   2. try-catch를 통한 처리 */
        ExceptionTest et = new ExceptionTest();

        /* 목차. 1. throws로 처리 시 */
//        et.checkEnoughMoney(50000, 10000);
        
        /* 목차. 2. try-catch로 처리 시 */
        try {
            /* 설명. try 블록은 처리 할 예외가 발생할 적당한 범위를 감싼다. */
            et.checkEnoughMoney(10000, 50000);
            et.checkEnoughMoney(50000, 10000);
        } catch (ArithmeticException e) {
            /* 설명.
            *   try 블록에서 발생한 예외(객체)를 처리하는 부분
            *   예외 객체를 활용하게 되면 해당 예외 객체의 메소드를 사용할 수 있다. */
            System.out.println("exception occured");
            System.out.println(e.getMessage());

            /* 설명. 예외 메시지의 발생한 문제들을 추적할 수 있게 빨간 글씨의 메시지로 처리되는 방식 */
            e.printStackTrace();
//            System.exit(0); // 프로그램 즉시 종료
        }

//        try {
//            int num = 10;
//            System.out.println(num / 0);
//        } catch (Exception e) { // 다형성. 즉 Exception이 ArithmeticException의 부모기에 대입 가능.
//            System.out.println("what? devide by zero?");
//            System.out.println(e.getMessage());
//        }

        System.out.println("exit program");
    }
}
