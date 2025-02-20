package com.ohgiraffers.section05.typecasting;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. 강제 형변환 규칙에 대해 이해할 수 있다. */
        /* 설명.
         *  강제형변환
         *  바꾸려는 자료형으로 캐스팅 연산자((자료형))를 이용하여 변환.
        * */

        long lNum = 8000000000L;
        int iNum = (int)lNum;                                   // 경우에 따라 부호 및 값까지 바뀌면서 데이터 손실 발생
        System.out.println("iNum = " + iNum);                   // -589934592

        float avg = 31.235f;
        int floorNum = (int)avg;
        System.out.println("floorNum = " + floorNum);           // 31
    }
}
