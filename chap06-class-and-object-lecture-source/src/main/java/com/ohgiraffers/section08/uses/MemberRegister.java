package com.ohgiraffers.section08.uses;

public class MemberRegister {

    public void regist(Member[] members) {
        System.out.println("회원을 등록합니다.");

        for (Member member : members) {
            System.out.println(member.getName() + "님 가입을 환영합니다.");
        }

        MemberRepository.store(members);
    }
}
