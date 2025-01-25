package com.ohgiraffers.section01.array;

import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. 배열의 사용 방법을 익혀 배열을 사용할 수 있다. */
        int[] iArr;
        char[] cArr;

        iArr = new int[5];
        cArr = new char[5];
        System.out.println(Arrays.toString(iArr));
        System.out.println(Arrays.toString(cArr));

        System.out.println(iArr);
        System.out.println(cArr);
        // 주소를 10진수로 보고 싶다
        System.out.println(cArr.hashCode());

        cArr = null;
        System.out.println(cArr.hashCode());
    }
}
