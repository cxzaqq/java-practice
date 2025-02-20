package com.ohgiraffers.section08.uses;

import java.util.Arrays;

public class MemberService {

    /* 설명. 회원 가입을 5명 진행하기 위해 회원 가입용 객체의 메소드를 호출(전달 인자 사용) */
    public void signUpMembers() {
        Member[] members = new Member[5];
        members[0] = new Member(1, "user01", "pass01", "홍길동1", 21, 'M');
        members[1] = new Member(2, "user02", "pass02", "홍길동2", 22, 'F');
        members[2] = new Member(3, "user03", "pass03", "홍길동3", 23, 'M');
        members[3] = new Member(4, "user04", "pass04", "홍길동4", 24, 'F');
        members[4] = new Member(5, "user05", "pass05", "홍길동5", 25, 'M');

        MemberRegister register = new MemberRegister();
        register.regist(members);
    }

    public void showAllMembers() {
        MemberFinder finder = new MemberFinder();
        System.out.println("=== 가입한 회원 목록 ===");
        Member[] returnMembers = finder.findAllMembers();
        for (Member member : returnMembers) {
            System.out.println(member);
        }
    }
}
