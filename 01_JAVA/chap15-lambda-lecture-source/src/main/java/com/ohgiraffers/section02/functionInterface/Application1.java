package com.ohgiraffers.section02.functionInterface;

import java.time.LocalTime;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 표준 함수적 인터페이스 중 Consumer 에 대해 이해하고 사용할 수 있다. */
        /* 설명. 반환형이 없는 메소드 관련 람다식 */
        Consumer<String> consumer = (str) -> System.out.println(str + "(이)가 입력됨");
        consumer.accept("피카츄");

        BiConsumer<String, LocalTime> biConsumer =
                (str, time) -> System.out.println(str + "(이)가 " + time + "에 입력됨");
        biConsumer.accept("피카츄", LocalTime.now());

        /* 설명.
        *   (int)(Math.random() * count) + ini
        *   new Random().nextInt(count) + ini (다운 캐스팅 필요 없음) */
        /* 설명. 제네릭에는 Object 타입만 적어주면 됨 */
        ObjIntConsumer<Random> objIntConsumer =
                (random, bound) -> System.out.println("1부터 " + bound + "까지의 난수 생성: "
                + (random.nextInt(bound) + 1));
        objIntConsumer.accept(new Random(), 10);

    }
}
