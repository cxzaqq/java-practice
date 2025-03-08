package com.ohgiraffers.chap01.section01.timecomplexity;

/* 수업목표. 시간 복잡도를 이해할 수 있다. */
/* 설명. 알고리즘 실행 시 입력 값이 증가함에 따라 연산이 걸리는 시간의 증가도를 나타낸다. */
public class Application {
    public static void main(String[] args) {

        int[] arr = new int[]{3, 1, 2, 15, 4, 9, 10, 7};
        System.out.println(getFirst(arr));
    }
    /* 설명. 상수 시간 O(1) */
    /* 설명. 
    *   입력값의 크기와 상관 없이 항상 일정한 시간이 걸리는 알고리즘. */
    private static int getFirst(int[] arr) {
        return arr[0];
    }
}
