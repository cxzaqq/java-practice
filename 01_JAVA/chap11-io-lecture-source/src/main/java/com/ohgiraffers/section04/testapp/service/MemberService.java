package com.ohgiraffers.section04.testapp.service;

import com.ohgiraffers.section04.testapp.aggregate.AccountStatus;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.repository.MemberRepository;
import java.util.ArrayList;

/* 설명. 트랜잭션 처리(성공 실패에 따라 Commit, Rollback) 및 회원 관리 비즈니스 로직 처리 */
public class MemberService {

    private final MemberRepository mr = new MemberRepository();
    public void findAllMembers() {
        ArrayList<Member> findMembers = mr.selectAllMembers();
        System.out.println("Service에서 조회 확인");
        for (Member member : findMembers) {
            System.out.println(member);
        }
    }

    public void findMemberBy(int memNo) {
        if (memNo == -1) return;
        Member findMember = mr.selectMemberBy(memNo);

        if(findMember != null) {
            System.out.println("회원 조회 성공: " + findMember);
        } else {
            System.out.println(memNo + "번 회원은 없습니다.");
        }
    }

    public void registMember(Member member) {
        
        /* 설명. 회원가입 시 입력 받은 값 제외 두 개를 마저 채우기 */
        /* 설명. 1. 회원 번호 추가 */
        int lastMemberNo = mr.selectLastMemberNo();
        member.setMemNo(lastMemberNo + 1);
        
        /* 설명. 2. 회원 활성화 상태 추가 */
        member.setAccountStatus(AccountStatus.ACTIVATE);

        /* 설명. 모든 DML 작업(INSERT/UPDATE/DELETE)이 일어난 행(객체)의 개수 */
        int result = mr.insertMember(member);
//        System.out.println("insert 성공 여부: " + result);

        if (result == 1) {
            System.out.println("회원가입을 축하드립니다! " + member.getId() + "님!");
        } else {
            System.out.println("회원가입에 실패하였습니다.");
        }
    }

    public Member findMemberForMod(int memNo) {
        Member selectedMember = mr.selectMemberBy(memNo);

        if (selectedMember != null) {
            /* 설명. 조회된 회원을 그대로 반환해서 수정하면 Repository의 컬렉션에 담긴 객체가 수정된다.
            *   따라서 우리는 사본의 개념을 만들어 Repository의 컬렉션이 오염되지 않도록 할 것이다. */
            Member newInstance = new Member();
            newInstance.setMemNo(selectedMember.getMemNo());
            newInstance.setId(selectedMember.getId());
            newInstance.setPwd(selectedMember.getPwd());
            newInstance.setAge(selectedMember.getAge());

            /* 설명. 취미는 배열이고 배열은 깊은 복사를 해야 사본으로 보낼 수 있다. */
            String[] copiedHobbies = selectedMember.getHobbies().clone();
            newInstance.setHobbies(copiedHobbies);
            newInstance.setBloodType(selectedMember.getBloodType());
            newInstance.setAccountStatus(selectedMember.getAccountStatus());

            System.out.println("조회된 회원(사본)은: " + newInstance);
            return newInstance;
        } else {
            System.out.println("없는 회원 입니다.");
        }

        return selectedMember;
    }

    public void modifyMember(Member reformedMember) {
        int result = mr.updateMember(reformedMember);
        
        if (result == 1) {
            System.out.println(reformedMember.getId() + " 회원님의 정보를 수정했습니다.");
        } else {
            System.out.println("회원정보 수정 실패");
        }
    }

    public void removeMember(int removeMemNo) {
        int result = mr.deleteMember(removeMemNo);
        if (result == 1) {
            System.out.println(removeMemNo + "번 회원 탈퇴를 성공하였습니다.");
        } else {
            System.out.println("회원 탈퇴 실패");
        }
    }
}
