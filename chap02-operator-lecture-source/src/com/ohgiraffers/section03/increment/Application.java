package com.ohgiraffers.section03.increment;

public class Application {
    public static void main(String[] args) {
        /* 수업목표. 단항 연산자이자 증감연산자에 대해 이해하고 활용할 수 있다. */
        int num = 20;
        num++;                      // 후위 연산자
        System.out.println("num = " + num);

        ++num;                      // 전위 연산자
        System.out.println("num = " + num);

        num--;
        System.out.println("num = " + num);

        --num;
        System.out.println("num = " + num);

        // 연산 중 혹 출력문에서의 전위 후위 차이
        int firstNum = 20;
        int result = firstNum++ + 3;
        System.out.println("result = " + result);
        System.out.println("firstNum = " + firstNum);

        firstNum--;
        result = ++firstNum + 3;
        System.out.println("result = " + result);
        System.out.println("firstNum = " + firstNum);


    }
}
