package com.ohgiraffers.section07.initblock;

public class Application {
    public static void main(String[] args) {

        /* 설명. 생성자가 여러 개일 때 공통적으로 수행해야 하는 로직이 있을 때
        *   초기화 블럭을 사용한다. */
        Product product = new Product();
        System.out.println(product);
    }
}
