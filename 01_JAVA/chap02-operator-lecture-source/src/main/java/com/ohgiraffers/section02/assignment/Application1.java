package com.ohgiraffers.section02.assignment;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 복합대입 연산자를 이해하고 활용할 수 있다. */
        /* 설명.
         *  대입연산자의 산술 복합 대입 연산자
         *  '=', '+=', '-=', '/=', '%='
        * */

        int num = 12;
        num = num + 1;
        num += 1;

        num = num - 1;
        num -= 1;

        num = num * 2;
        num *= 2;

        num = num / 2;
        num /= 2;

        num = num % 5;
        num %= 5;

        // 주의 num =- 5; => 순서가 바뀌면 대입이 됨.
    }
}
