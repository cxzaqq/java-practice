package com.ohgiraffers.section02.string;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Application3 {
    public static void main(String[] args) {
        /* 수업목표. 문자열 분리에 대해 이해하고 적용할 수 있다. */
        /* 설명.
        *   문자열을 특정 구분자로하여 분리한 문자열들을 변환하는 기능을 한다.
        *   1. split(): 정규표현식을 이용하여 비정형화된 문자열을 분리한다.
        *               (String을 파싱하여 String[]로 변환
        *   2. StringTokenizer: 문자열의 모든 문자들을 구분자를 통하여 문자열이 분리된다.
        *                       (StringTokenizer가 제공하는 메소드들과 while문을 활용하여 분리 가능 */

        /* 목차. 1. split() 활용 */
        String emp1 = "100/홍길동/서울/영업부";
        String emp2 = "200/유관순//총무부";
        String emp3 = "300/이순신/경기도/";

        String[] empArr1 = emp1.split("/");
        String[] empArr2 = emp2.split("/");
        /* 설명. /와 ?로 나누겠다. 두 개 이상 사용 시에는 대괄호 사용해야 함 */
        String[] empArr3 = emp3.split("[/?]");

        System.out.println(Arrays.toString(empArr1));
        System.out.println(Arrays.toString(empArr2));
        System.out.println(Arrays.toString(empArr3));

        /* 목차. 2. StringTokenizer 활용 */
        String colors = "red, yellow, green, purple? blue";
        /* 설명. delim을 두 개 이상 사용하고 싶으면 띄워 쓰면 됨 */
        // 토큰으로 나뉜 객체 생성
        StringTokenizer colorStringTokenizer = new StringTokenizer(colors, ", ?");
        while (colorStringTokenizer.hasMoreTokens()) { // 토큰이 있니?
            System.out.println(colorStringTokenizer.countTokens());
            /* 설명. 현재의 반복 회차 안에서 해당 토큰을 여러번 쓰고 싶으면 변수에 담아 써야 함 */
            String token = colorStringTokenizer.nextToken(); // 토큰을 반환하고 커서를 옮겨라
            System.out.println(token);
        }
    }
}
