package com.ohgiraffers.section07.initblock;

public class Product {
    private String name = "아이폰";
    private int price;
    private static String brand;

    /* 설명. 초기화 블럭은 생성자 이전에 실행되며 어떤 생성자로 객체를 생성하든 공통적인 로직이 있다면 작성 */
    // 인스턴스 초기화 블럭.
    {
        System.out.println("아빠 안 잔다..");
        price = 170;
        Product.brand = "삼성";
    }

    // static 초기화 블럭. 무조건 인스턴스 초기화 블럭보다 먼저 실행된다.
    static {
//        price = 200; // static 초기화 블럭에서는 인스턴스 변수에 접근 불가
        Product.brand = "LG";
    }

    public Product() {
        System.out.println("기본 생성자 호출...");
        name = "갤럭시";
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + Product.brand + '\'' +
                '}';
    }
}
