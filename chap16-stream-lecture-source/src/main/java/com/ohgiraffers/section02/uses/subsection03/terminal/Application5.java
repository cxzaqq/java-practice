package com.ohgiraffers.section02.uses.subsection03.terminal;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Application5 {
    public static void main(String[] args) {

        /* 설명. 메소드 참조 관련 추가 설명(람다식 관련) */
        BiConsumer<Member, String> biConsumer;
        biConsumer = Member::setMemberId;
        biConsumer = (x, y) -> x.setMemberId(y);

        /* 설명. 객체가 정해지면 참조 자료형 변수로 사용 가능(이 객체에만 적용) */
        Consumer<String> consumer;
        Member m = new Member("1", "user");
        consumer = m::setMemberId;
        consumer = (x) -> m.setMemberId(x);
    }
}
