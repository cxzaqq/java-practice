package com.ohgiraffers.section03.reference;

import java.util.function.Function;
import java.util.function.Supplier;

public class Application2 {

    /* 수업목표. 기존에 존재하는 생성자를 참조한 람다식을 활용 */
    public static void main(String[] args) {
//        Function<String, Member> costMember = x -> { return new Member(x); };
        Function<String, Member> costMember = Member::new; // 제네릭 타입을 보고 Member의 타입에 맞는 생성자를 호출
        // 첫 번째 제네릭이 String이면 생성자 중 매개변수를 String으로 받는 생성자로 판단

        Member member1 = costMember.apply("A"); // 이 시점에 객체가 생성되는 것
        System.out.println("member1: " + member1);

        Member member2 = costMember.apply("B");
        System.out.println("member2: " + member2);

        /* 설명. Supplier는 매개변수가 없기에 Member의 기본 생성자를 호출한다. */
        Supplier<Member> costMember2 = Member::new;
    }
}
