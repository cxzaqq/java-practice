package com.ohgiraffers.section01.intro;

/* 설명. 이 어노테이션은 추상 메소드를 두 개 이상 못 가지게 할 수 있음 */
/* 설명. FunctionalInterface만 람다식으로 적용 가능하다. */
@FunctionalInterface
public interface Calculator {
    int sumTwoNumbers(int first, int second);
//    void test();
}
