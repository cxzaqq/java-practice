package com.ohgiraffers.section02.variable;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. 변수를 선언하고 값을 할당하여 사용할 수 있다.(feat. 자료형) */

        /* 목차. 1. 정수를 취급하는 자료형 */        // byte
        byte bNum;                              // 1
        short sNum;                             // 2
        int iNum;                               // 4
        long lNum;                              // 8

        /* 목차. 1. 실수를 취급하는 자료형 */
        float fNum;                             // 4
        double dNum;                            // 8

        /* 목차. 1. 문자를 취급하는 자료형 */
        char ch;                                // 2

        /* 목차. 1. 논리값를 취급하는 자료형 */
        boolean isTrue;                         // 1

        /* 목차. 1. 문자열를 취급하는 자료형 */
        String str;

        /* 설명. 각 변수에 값 대입해 보기 */        // 자바는 정수는 int로, 실수는 double로 처음에 인식함
        bNum = 127;
        sNum = 32767;
        iNum = 2147483647;
        lNum = 20000000000L;                    // 대략 21억5천만이 넘으면 L을 붙여야 함

        fNum = 3.14f;
        dNum = -3.14;
        
        ch = 'a';
        ch = 97;                                // 양수만 가능 ∵ 아스키 코드나 유니코드에는 음수가 없음

        isTrue = true;

        /* 설명. 변수를 활용한 합계, 평균 출력해 보기 */
        int kor = 98;
        int math = 80;
        int eng = 75;

        int sum = kor + math + eng;
        System.out.println(sum);

        double avg = sum / 3.0;
        System.out.println(avg);

    }
}
