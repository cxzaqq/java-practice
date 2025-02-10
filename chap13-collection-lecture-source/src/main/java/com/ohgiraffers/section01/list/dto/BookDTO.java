package com.ohgiraffers.section01.list.dto;

import java.util.Objects;

public class BookDTO implements Comparable<BookDTO> {
    private int number;
    private String title;
    private String author;
    private int price;

    public BookDTO() {
    }

    public BookDTO(int number, String title, String author, int price) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    /* 설명. 객체를 둘 씩 꺼내서 비교한다.
    *   사용자는 기준만 정하면 됨. Collections에서 이걸 호출함
    *   해당 필드가 String일 경우 String에 정의된 compareTo() 메소드를 활용한다. */
    @Override
    public int compareTo(BookDTO o) {

        /* 설명. 가격 오름차순 */
//        return this.price - o.price;

        /* 설명. 가격 내림차순 */
//        return o.price - this.price;

        /* 설명. 책 제목 오름차순 */
//        return this.title.compareTo(o.title);

        /* 설명. 책 제목 내림차순 */
        return o.title.compareTo(this.title);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookDTO bookDTO = (BookDTO) o;
        return price == bookDTO.price && Objects.equals(title, bookDTO.title) && Objects.equals(author,
                bookDTO.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price);
    }
}
