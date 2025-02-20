package com.ohgiraffers.section01.array;

import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 배열에 대해 이해하고 배열의 사용 목적을 이해할 수 있다. */
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        int num4 = 40;
        int num5 = 50;

        int sum = 0;

        sum += num1;
        sum += num2;
        sum += num3;
        sum += num4;
        sum += num5;

        System.out.println("sum = " + sum);

        int[] arr = new int[5];
        System.out.println("arr = " + arr);
        System.out.println(Arrays.toString(arr)); // 1차원 배열일 경우만 가능

        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i + 1) * 10;
            sum2 += arr[i];
        }
        System.out.println("sum2 = " + sum2);


    }
}
