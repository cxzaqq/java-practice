package com.ohgiraffers.section01.array;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표. 배열에 초기ㅗ하 되는 자료형별 기본값을 이해할 수 있다. */
        /* 설명.
        *   정수: 0
        *   실수: 0.0
        *   논리: false
        *   문자: \u0000
        *   참조: null
        *  */

        int[] iArr = {10, 11, 12, 13, 14};
        int[] iArr2 = new int[]{10, 11, 12, 13, 14};

//        test({10, 11, 12, 13, 14});
        test(new int[]{10, 11, 12, 13, 14});

        /* 설명. 배열 반복문 */
        // 단순 반복문
        for (int i = 0; i < iArr.length; i++) {
            System.out.println(iArr[i]);
        }

        // foreach 문
        for (int num : iArr2) {
            System.out.println(num);
        }
    }

    public static void test(int[] arr) {

    }
}
