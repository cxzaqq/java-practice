package com.ohgiraffers.section01.literal;

public class Application1 {
    public static void main(String[] args) {
        /* todo. */
        /* 수업목표. 여러 가지 값의 형태를 출력할 수 있다. */
        /* 목차. 1. 숫자 형태의 값 */
        /* 목차. 1-1. 정수 형태의 값 출력 */
        System.out.println(123);

        /* 목차. 1-2. 실수 형태의 값 출력 */
        System.out.println(1.23);

        /* 목차. 2. 문자 형태의 값 출력 */
        System.out.println('a');
        System.out.println('1');
        System.out.println('\u0000'); // 유니코드로 0번이고 아무것도 없다는 뜻

        /* 목차. 문자열 형태의 값 출력 */
        System.out.println("안녕하세요");
        System.out.println("a");
        System.out.println("");

        /* 목차. 논리 형태의 값 출력 */
        System.out.println(true);
//        System.out.println("true"); // 문자열과 논리값은 다름
        System.out.println(false);
    }
}