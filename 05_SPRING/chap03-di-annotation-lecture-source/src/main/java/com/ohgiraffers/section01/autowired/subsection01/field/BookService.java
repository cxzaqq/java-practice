package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDAOImpl;
import com.ohgiraffers.section01.common.BookDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    /* 설명.
    *   아래의 세 가지는 ComponentScan 범위 안에 어노테이션이 달렸을 때 유효하다.
    *   1. @Service에 의해서 BookService 타입의 bookService id의 bean이 관리된다.
    *   2. BookDAOImpl에 있는 @Repository에 의해서 bookDAOImpl id의 bean이 관리된다. (BookDAO 타입이기도 하다.)
    *   3. @AutoWired에 의해서 bookDAO 타입의 bean이 BookService의 필드인 bookDAO 필드에 주입(대입)된다.
    *       (=필드 주입) */
    
    /* 설명.
    *   private BookDAO bookDAO = new BookDAOImpl();
    *   원래 이렇게 작성해야 하는 것을 @Autowired 사용하면 아래처럼 가능  */
    @Autowired
    private BookDAO bookDAO; // ComponentScan 범위 안에 BookDAO 타입의 bean이 존재
    /* 설명. 콩이 볶아지는데 이때 BookService 클래스의 객체가 생성됨.
            객체가 생성된다는 것은 필드부터 기본 생성자까지 진행된다는 것.
    *       객체를 생성하려고 보니 필드에 Autowired가 있네?
    *       잠깐 멈춤
    *       BookDAO라는 콩이 나에게 있나? => 없음
    *       BookDAO를 구현하는 BookDAOImpl이라는 콩이 볶아짐
    *       멈춰있던 게 다시 진행 */

    public BookService() {
    }

    /* 설명. 도서 목록 전체 조회 */
    public List<BookDTO> findAllBook() {
        /* 설명. 즉 여기에서 bookDAO는 @Autowired로 주입된 BookDAOImpl인 것임 */
        return bookDAO.findAllBook();
    }

    /* 설명. 도서 번호로 도서 조회 */
    public BookDTO findBookBySequence(int sequence) {
        return bookDAO.findBookBySequence(sequence);
    }
}
