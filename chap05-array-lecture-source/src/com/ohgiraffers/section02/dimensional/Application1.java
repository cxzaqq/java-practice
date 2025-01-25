package com.ohgiraffers.section02.dimensional;

import java.util.Arrays;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표. 다차원 배열의 구조를 이해하고 사용할 수 있다. */

        int[][] arr1;
        int[] arr2[];   // 지양
        int arr3 [][];  // 지양
        
        arr1 = new int[3][2];                                   // 정변 배열
        arr2 = new int[3][];                                    // 가변 배열

        int num = 0;
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = ++num;
            }
            System.out.println(Arrays.toString(arr1[i]));
        }
        
        /* 설명. 가변배열에 다양한 길이의 1차원 배열을 적용해 보자 */
        arr2[0] = new int[]{1, 2, 3};
        arr2[1] = new int[]{1, 2, 3, 4};
        arr2[2] = new int[]{3, 3};

        for (int[] nums : arr2) {
            System.out.println(Arrays.toString(nums));
        }
    }
}
