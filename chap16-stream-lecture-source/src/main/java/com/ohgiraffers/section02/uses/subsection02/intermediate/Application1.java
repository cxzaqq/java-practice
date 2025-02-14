package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {
        /* XXX.aaa().bbb(); => aaa()가 중개 연산, bbb()가 최종 연산 */

        /* 설명. 스트림의 중계 연산 중 하나인 filter에 대해 이해하고 사용할 수 있다. */
        /* 설명. 중계 연산: Stream을 반환하며 Stream 관련 메소드 체이닝 상에서 중간에 위치한다. */

        /* 설명. filter는 스틀미에서 특정 데이터만을 걸러내기 위한 메소드이다. */
        IntStream intStream = IntStream.range(0, 10);
        intStream.filter(i -> i % 2 == 0)
                .forEach(i -> System.out.print(i + " "));
    }
}
