package com.ohgiraffers.section01.object.run;

import com.ohgiraffers.section01.object.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        BookDTO book1 = new BookDTO(1, "홍길동전", "허균", 50000);
        BookDTO book2 = new BookDTO(2, "홍길동전", "허균", 50000);

        /* 설명.
        *   동일 비교: 주소값 비교(같은 객체인가?)
        *   동등 비교: 특정 기준을 만족하는가? ex) 필드들의 값이 같으면 같은 것으로 반환 */
        System.out.println("두 인스턴스를 == 연산자로 비교: " + (book1 == book2));

        /* 설명.
        *   Override 전에는 Objects에 정적 바인드된 equals() 메소드로 찾아진다.
        *   Override 후에는 BookDTO의 Override된 equals()로 찾아진다. */
        System.out.println("두 인스턴스를 equals() 메소드로 비교: " + (book1.equals(book2)));
        System.out.println();

        /* 설명.
        *   Override 전에는 Objects에 정적 바인드된 hashCode() 메소드로 찾아진다.
        *   Override 후에는 BookDTO의 Override된 hashCode() 메소드로 찾아진다.
        *
        *  설명. 그래서 이건 왜 재정의 하는데?
        *   hashCode로 먼저 분류를 하고 이 분류가 같으면 equals()를 사용해서 효율을 높일 수 있다.
        * */
        System.out.println("book1의 hashCode: " + book1.hashCode());
        System.out.println("book2의 hashCode: " + book2.hashCode());

    }
}
