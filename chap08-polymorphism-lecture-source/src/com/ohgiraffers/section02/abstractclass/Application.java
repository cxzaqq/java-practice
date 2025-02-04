package com.ohgiraffers.section02.abstractclass;

public class Application {
    public static void main(String[] args) {
//        Product p = new Product(); // 추상 클래스는 생성 불가

        Phone smartPhone = new Phone();
        smartPhone.abstractMethod();

        Product smartPhone2 = new Phone();
        smartPhone2.abstractMethod();
    }
}
