package com.ohgiraffers.section01.list.run;

import java.util.Stack;

public class Application4 {
    public static void main(String[] args) {

        /* 수업목표. Stack에 대해 이해하고 사용할 수 있다. */
        /* 설명.
        *   Stack?
        *   LIFO(Last In First Out) 자료구조로 push(), pop(), peek() 등의 메소드를 활용하여 처리 가능 */
        Stack<Integer> integerStack = new Stack<>();

        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);

        System.out.println("Stack: " + integerStack);

        System.out.println("peek(): " + integerStack.peek());

        /* 설명. auto boxing 후 동등 비교가 일어난다.
        *   커스텀 객체 사용 시 hashCode(), equals()를 재정의 해야 함 그래야 search가 동작함 */
        System.out.println("search(): " + integerStack.search(2));

        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println("Stack: " + integerStack);
    }
}
