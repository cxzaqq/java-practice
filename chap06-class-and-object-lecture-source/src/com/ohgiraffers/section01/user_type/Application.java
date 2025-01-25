package com.ohgiraffers.section01.user_type;

public class Application {

    /* 설명.
    *   객체지향프로그래밍(OOP)란?
    *   Object Oriented Programming
    *   : 추상화, 캠슐화, 상속, 다형성을 적용하여 유지보수성을 고려한 응집력 높고 결합도 낮은
    *     객체 위주의 개발 방식을 적용한 프로그래밍
    *
    *  설명.
    *   - 추상화(Abstraction)
    *   - 캡슐화(Encapsulation)
    *   - 상속(Inheritance)
    *   - 다형성(Polymorphism)
    *  */
    public static void main(String[] args) {

        String id = "user01";
        String pw = "pw01";
        String name = "hong";
        int age = 20;
        char gender = '남';
        String[] hobbies = new String[]{"축구", "볼링", "테니스"};

        /* 설명. 
        *   이렇게 변수들로만 관리할 때 발생할 수 있는 문제점
        *   1. 많은 변수들을 관리하기 어렵다.(한 묶음으로 생각하거나 코딩할 수 없다.)
        *   2. 메소드의 전달인자로 전달할 값이 많으므로 매개변수의 개수가 늘어난다.
        *   3. 메소드의 반환형으로 하나의 타입만 가능하기에 많은 변수 반환은 불가능 */

        
        Member member1 = new Member(); // 인스턴스화(instanciation)(메모리의 힙 영역에 올리는 것)
        Member member2 = new Member();

        System.out.println("member2 = " + member2.name);
        Member renameMember = test(member2);
        System.out.println("renameMember = " + renameMember.name);
    }

    private static Member test(Member member) {
        member.name = "honghonghong";
        return member;
    }


}
