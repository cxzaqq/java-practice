package com.ohgiraffers.section02.uses.subsection01.generation;

import java.util.Arrays;
import java.util.stream.Stream;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 배열이나 컬렉션은 스트림을 이용할 수 있고 이를 이해해서 활용할 수 있다. */
        String[] sArr = new String[]{"java", "mariaDB", "jdbc"};

        /* 목차. 1. 배열로 스트림 생성 */
        /* 설명. Arrays.stream(배열): 배열 자료형을 Stream 자료형으로 변환 */
        System.out.println("==== 배열로 스트림 생성 ====");
        Stream<String> strStream1 = Arrays.stream(sArr);

        /* 설명. forEach는 자신의 매개변수에 정의된 람다식의 매개변수로 stream의 각 요소들을 자동으로 넘기며 순회함
        *   순회? 매개변수를 넘기고 람다식 실행을 반복 */
//        strStream1.forEach(x -> System.out.println(x));
        strStream1.forEach(System.out::println);

//        Arrays.stream(sArr).forEach(System.out::println); // 이렇게 한 줄로 가능!
        System.out.println();

        /* 설명. startInclusive ~ endExclusive - 1 인덱스 구간의 배열을 스트림으로 */
        Stream<String> strStream2 = Arrays.stream(sArr, 0, 2);
        strStream2.forEach(System.out::println);
        
        /* 설명. 
        *   Builder를 활용한 스트림 생성
        *   builder는 statkc<T>로 되어 있는 메소드이며 호출 시 타입 파라미터를 메소드 호출 방식으로 전달한다 */
        System.out.println("=== Builder로 스트림 생성 ===");
        Stream<String> builderStream = Stream.<String>builder()
                                            .add("홍길동")
                                            .add("유관순")
                                            .add("윤봉길")
                                            .build();
        builderStream.forEach(System.out::println);

    }
}
