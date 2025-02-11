package com.ohgiraffers.section04.testapp.run;

import com.ohgiraffers.section04.testapp.service.MemberService;
import java.util.Scanner;

public class Application {

    private static final MemberService ms = new MemberService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("===== 회원 관리 프로그램 =====");
            System.out.println("1. 모든 회원 정보 보기");
            System.out.println("2. 회원 찾기");
            System.out.println("3. 회원 가입");
            System.out.println("4. 회원 정보 수정");
            System.out.println("5. 회원 탈퇴");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요: ");
            int input = sc.nextInt();

            switch (input) {
                case 1: ms.findAllMembers(); break;
                case 2: ms.findMemberBy(chooseMemNo()); break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 9:
                    System.out.println("회원 관리 프로그램을 종료합니다."); return;
                default:
                    System.out.println("잘못된 메뉴입니다.");
                break;
            }
        }
    }

    /* 설명. 회원 번호를 입력 받아 int로 반환 */
    private static int chooseMemNo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("회원 번호 입력: ");
        return sc.nextInt();
    }
}
