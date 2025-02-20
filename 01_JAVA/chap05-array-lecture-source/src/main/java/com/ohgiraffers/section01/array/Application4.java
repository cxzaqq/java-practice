package com.ohgiraffers.section01.array;

import java.util.Arrays;
import java.util.Scanner;

public class Application4 {
    public static void main(String[] args) {
        /* 수업목표. 배열을 사용하는 예시를 이해하고 작성할 수 있다. */
        int[] score = new int[5];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < score.length; i++) {
            System.out.println(i + 1);
            score[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(score));

        int sum = 0;
        for (int perScore: score) {
            sum += perScore;
        }

        System.out.println("sum = " + sum);

        double avg = (double)sum / score.length;
        System.out.println("avg = " + avg);


    }
}
