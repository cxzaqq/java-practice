package com.ohgiraffers.section01.list.comparator;

import com.ohgiraffers.section01.list.dto.BookDTO;
import java.util.Comparator;

/* 설명. BookDTO에 대해 추가적인 정렬 기준을 위한 클래스 */
/* 설명. 제네릭으로 BookDTO를 해줘야 자동완성 시에도 BookDTO 적용됨.
*   그냥 쓰면 Object 돼서 다운 캐스팅 해줘야 함. */
public class AscendingPrice implements Comparator<BookDTO> {

    @Override
    public int compare(BookDTO o1, BookDTO o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
