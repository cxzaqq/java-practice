package com.ohgiraffers.section01.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl implements BookDAO {
    
    /* 설명. 수정이 잦으면 Map, 아니면 List를 보통 사용 */
    private Map<Integer, BookDTO> bookList;

    /* 설명. JDBC를 활용한 실제 DB 연동 대신 dummy data로 초기화 */
    public BookDAOImpl() {
        bookList = new HashMap<>();
        bookList.put(1, new BookDTO(1, 123456, "자바의 정석",
                "남궁성", "도우출판", new java.util.Date()));
        bookList.put(2, new BookDTO(2, 234567, "칭고춤",
                "고래", "고래출판", new java.util.Date()));
    }

    @Override
    public List<BookDTO> findAllBook() {
        /* 설명. Map을 List로 변환 */
        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO findBookBySequence(int sequence) {
        return bookList.get(sequence);
    }
}
