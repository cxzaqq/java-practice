package com.ohgiraffers.section02.enumtype;

public class Application {
    public static void main(String[] args) {

//        Subjects subject1 = new Subjects(); // 직접 생성자 사용 불가
        Subjects subject1 = Subjects.JAVA;
        Subjects subject2 = Subjects.JAVASCRIPT;
        Subjects subject3 = Subjects.JAVA;

        /* 설명.
        *   1. 열거 타입으로 선언된 인스턴스는 싱글톤으로 관리되며 인스턴스가 각각 한 개임을 보장한다.
        *      작성한 순서에 따라 각각 다른 인스턴스가 생성되며 최초 호출 시에 enum의 생성자를 활용해 생성된다.
        *      (lazy singleton 개념)
        *   2. 단일 인스턴스를 보장하기에 == 비교(동일 비교)가 가능하다. */
        if(subject1 == subject3) {
            System.out.println("same subject");
        }

        /* 설명. 3. 상수 필드명을 문자열로 변경하기 쉽다. */
        System.out.println(Subjects.JAVA.toString()); // 재정의하여 사용 가능
        System.out.println(Subjects.JAVA.name());     // 재정의 불가

        /* 설명. 4. values()를 이용하면 상수값 배열을 반환받고 이를 활용하여 연속처리해 줄 수 있다. */
        Subjects[] subjects = Subjects.values();
        for(Subjects sub : subjects) {
            System.out.println(sub.toString());
            System.out.println(sub.ordinal()); // 선언된 순서를 인덱스 체계로 추출 가능
            System.out.println(sub.name());
        }

        /* 설명. 5. 타입 안정성을 보장한다. */
        printSubjects(Subjects.JAVA);
//        printSubjects(0); // 불가
    }

    private static void printSubjects(Subjects subjects) {
        System.out.println(subjects.toString());
    }
}
