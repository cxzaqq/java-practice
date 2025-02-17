package com.ohgiraffers.section04.testapp.repository;

import com.ohgiraffers.section04.testapp.aggregate.AccountStatus;
import com.ohgiraffers.section04.testapp.aggregate.BloodType;
import com.ohgiraffers.section04.testapp.aggregate.Member;
import com.ohgiraffers.section04.testapp.stream.MyObjectOutput;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/* 설명. DB 개념(Member 관련 파일)과 입출력(CRUD)을 위해 만들어지며 성공 데이터 또는 실패 여부를 반환
*   java의 컬렉션 개념으로 데이터를 관리하기도 한다. */
public class MemberRepository {

    /* 설명. 초기에 Member 파일이 없다면 파일을 만들어 더미 데이터를 쌓는다. */
    private final ArrayList<Member> memberList = new ArrayList<>();
    private final File file =
            new File("src/main/java/com/ohgiraffers/section04/testapp/db/memberDB.dat");

    /* 설명. 프로그램 구동 시 MemberRepository 생성자가 호출되며 초기에 실행할 내용들 */
    public MemberRepository() {
        if (!file.exists()) {
            ArrayList<Member> defaultMembers = new ArrayList<>();
            defaultMembers.add(new Member(1, "user01", "pass01", 20,
                    new String[]{"발레", "수영"}, BloodType.A, AccountStatus.ACTIVATE));
            defaultMembers.add(new Member(2, "user02", "pass02", 10,
                    new String[]{"게임", "영화감상"}, BloodType.B, AccountStatus.ACTIVATE));
            defaultMembers.add(new Member(3, "user03", "pass03", 30,
                    new String[]{"음악감상", "독서", "명상"}, BloodType.AB, AccountStatus.ACTIVATE));

            saveMembers(defaultMembers);
        }

        loadMembers();
    }

    /* 설명. 파일로부터 회원 객체들을 읽어와서 memberList 컬렉션에 저장 */
    private void loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        )) {
            while(true) {
                memberList.add((Member)ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("회원 정보 다 읽어옴");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /* 설명. ArrayList<Member>를 받으면 파일로 출력하는 메소드(덮어 씌우기) */
    private void saveMembers(ArrayList<Member> inputMembers) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)
                    )
            );

            for (Member member : inputMembers) {
                oos.writeObject(member);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Member> selectAllMembers() {
        return memberList;
    }

    public Member selectMemberBy(int memNo) {
        Member returnMember = null;
        for (Member member : memberList) {
            if(member.getMemNo() == memNo) {
                returnMember = member;
            }
        }
        return returnMember;
    }

    public int selectLastMemberNo() {
        Member lastMember = memberList.get(memberList.size() - 1);
        return lastMember.getMemNo();

    }

    public int insertMember(Member member) {

        /* 설명. 헤더가 추가되지 않는 ObjectOutputStream 클래스 정의(MyObjectOutputStream) */
        MyObjectOutput moo = null;
        int result = 0;

        try {
            moo = new MyObjectOutput(
                    new BufferedOutputStream(
                            /* 설명. append: true 해줘야 덮어쓰지 않고 이어서 입력됨 */
                            new FileOutputStream(file, true)
                    )
            );

            /* 설명. 파일에 신규 회원 추가 */
            moo.writeObject(member);

            /* 설명. 컬렉션에 신규 회원 추가 */
            memberList.add(member);

            result = 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(moo != null) moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    /* 설명. 수정된 사본이 넘어오면 컬렉션에 담긴 동일한 회원을 update 후 파일 덮어씌우기 */
    public int updateMember(Member reformedMember) {
        System.out.println("넘어온 정보: " + reformedMember);
        for (int i = 0; i < memberList.size(); i++) {
            if(memberList.get(i).getMemNo() == reformedMember.getMemNo()) {
                memberList.set(i, reformedMember); // 컬렉션 업데이트
                saveMembers(memberList); // 파일 업데이트
                return 1;
            }
        }

        return 0;
    }

    /* 설명. soft delete(일종의 업데이트)를 통해 회원 탈퇴를 구성 */
    public int deleteMember(int removeMemNo) {
        int result = 0;

        for (Member mem: memberList) {
            if (mem.getMemNo() == removeMemNo) {
                mem.setAccountStatus(AccountStatus.DEACTIVATE);
                result = 1;
                saveMembers(memberList);
            }
        }

        return result;
    }
}
