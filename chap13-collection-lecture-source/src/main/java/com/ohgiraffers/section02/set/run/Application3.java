package com.ohgiraffers.section02.set.run;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. TreeSet에 대해 이해하고 활용할 수 있다. */
        /* 설명. Tree 구조를 활용해 중복 제거 + 정렬을 해준다. */
        Set<String> tSet = new TreeSet<>();
        tSet.add("ramen");
        tSet.add("kimchi");
        tSet.add("pork");
        tSet.add("friedEgg");
        tSet.add("soup");
        tSet.add("soup");

        System.out.println("tSet: " + tSet);

        /* 설명. 로또 번호 발생기(보너스 번호 제외)
        *   1~45까지 중복되지 않고 오름차순 정렬된 6개의 값 추출하기 */
        Set<Integer> lotto = new TreeSet<>();
        while(lotto.size() < 6) {
            lotto.add((int)(Math.random() * 45) + 1);
        }
        System.out.println("lotto: " + lotto);

        /* 설명. 배열을 활용한 TressSet과 같은 기능을 하는 알고리즘 구현 */
        int[] lottoArr = new int[6];
        int idx = 0;
        boolean hasNum;
        while(idx < 6) {
            hasNum = false;
            int e = (int)(Math.random() * 45) + 1;
            for(int j = 0; j < lottoArr.length; j++) {
                if(lottoArr[j] == e) {
                    hasNum = true;
                    break;
                }
            }
            if(!hasNum) {
                lottoArr[idx] = e;
                idx++;
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5 - i; j++) {
                if(lottoArr[j] > lottoArr[j+1]) {
                    int tmp = lottoArr[j];
                    lottoArr[j] = lottoArr[j+1];
                    lottoArr[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(lottoArr));
    }
}
