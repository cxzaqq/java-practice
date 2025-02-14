package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 스트림의 최종연산(Terminal Operator) 중 하나인 calculation에 대해 이해하고 사용할 수 있다. */
        Long count = IntStream.range(1, 10).count();
        int sum = IntStream.range(1, 10).sum();

        System.out.println("count = " + count);
        System.out.println("sum = " + sum);
        System.out.println();

        /* 설명. OptionanlInt?
        *   기본자료형도 존재하지 않으면 empty라 표현함 */
        OptionalInt max = IntStream.range(1, 10).max();
        System.out.println("max = " + max);                         // max = OptionalInt[9]
        OptionalInt max2 = IntStream.range(1, 1).max();
        System.out.println("max2 = " + max2);                       // max2 = OptionalInt.empty

        OptionalInt min = IntStream.range(1, 10).min();
        System.out.println("min = " + min);                         // min = OptionalInt[1]
        OptionalInt min2 = IntStream.range(1, 1).min();
        System.out.println("min2 = " + min2);                       // min2 = Optional.empty
        System.out.println();

        int oddSum = IntStream.range(1, 10).filter(i -> i % 2 != 0).sum();
        System.out.println("oddSum = " + oddSum);
    }
}
