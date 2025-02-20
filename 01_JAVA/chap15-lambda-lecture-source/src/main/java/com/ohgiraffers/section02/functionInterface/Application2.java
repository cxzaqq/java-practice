package com.ohgiraffers.section02.functionInterface;

import java.time.LocalDateTime;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 표준 함수적 인터페이스 중 Supplier에 대해 이해하고 사용할 수 있다. */
        /* 설명. 매개변수 없고 반환값만 있는 메소드 관련 람다식 */

        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get());

        /* 설명. 반환형이 이미 이름에 있어 제네릭 없어도 됨 */
        BooleanSupplier booleanSupplier = () -> {
            int random = (int)(Math.random() * 2);
            return random == 0 ? false : true;
        };
//        BooleanSupplier booleanSupplier2 = () -> (int)(Math.random() * 2) == 0 ? true : false;
        System.out.println("랜덤 true or false 생성기: " + booleanSupplier.getAsBoolean());


    }
}
