package com.ohgiraffers.section03.stringbuilder;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. String과 StringBuilder의 차이점에 대해 이해하고 사용할 수 있다. */
        StringBuilder sb = new StringBuilder("java");

        String testStr = "java";
        StringBuilder testSb = new StringBuilder("kotlin");

        for (int i = 0; i < 9; i++) {
            testStr += i;
            /* 설명. String은 새로운 객체가 계속 생성되지만 StringBuilder는 새로 생성하지 않고 용량을 늘린다. */
            testSb.append(i);

            System.out.println("String: " + System.identityHashCode(testStr));
            System.out.println("StringBuilder: " + System.identityHashCode(testSb));
        }

        System.out.println("String: " + testStr);
        System.out.println("StringBuilder: " + testSb);
    }
}
