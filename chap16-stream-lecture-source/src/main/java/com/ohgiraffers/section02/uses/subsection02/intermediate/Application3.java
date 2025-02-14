package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. 스트림의 중계 연산 중 하나인 sorted에 대해 이해하고 사용할 수 있다. */
        List<Integer> iList = IntStream.of(5, 10, 99, 2, 1, 35)          // intStream을
                                        .boxed()                                // stream으로 만들고
//                                        .sorted()                               // 정렬(오름차순) 후
                                        .sorted(new DescInteger())              // 정렬(내림차순) 후
                                        /* 설명. collect()는 Collectors에서 제공하는 메소드들을 사용 가능하다 */
                                        .collect(Collectors.toList());          // list로 반환한다.
        System.out.println("정렬된 list: " + iList);
    }
}
