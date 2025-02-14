package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.Arrays;
import java.util.List;

public class Application4 {
    public static void main(String[] args) {

        /* 수업목표. 스트림의 최종 연산 중 하나인 match에 대해 이해하고 사용할 수 있다. */
        List<String> strList = Arrays.asList("Java", "Spring", "SpringBoot");

        /* 설명. 하나라도 true면 true */
        boolean anyMatch = strList.stream().anyMatch(str -> str.contains("p"));

        /* 설명. 하나라도 false면 false */
        boolean allMatch = strList.stream().allMatch(str -> str.length() > 4);

        /* 설명. 하나라도 true면 false */
        boolean noneMatch = strList.stream().noneMatch(str -> str.contains("c"));

        System.out.println("anyMatch = " + anyMatch);
        System.out.println("allMatch = " + allMatch);
        System.out.println("noneMatch = " + noneMatch);
    }
}
