package com.ohgiraffers.section03.interfaceImplements;

public interface InterProduct extends ParentInterProduct, AnotherParentInterProduct {
//    public static final int MAX_NUM = 100; // 정석
    int MAX_NUM = 100; // 생략 가능

    /* 설명. 인터페이스는 생성자를 가질 수 없다.(객체를 만들 수 없다.) */
//    public InterProduct() {}

//    public abstract void nonStaticMethod(); // 정석
    void nonStaticMethod();
//    void nonStaticMethod2();
//    void nonStaticMethod3();
//    void nonStaticMethod4();
//    void nonStaticMethod5();

    /* 설명. static 메소드를 사용하면 메소드의 바디부까지 작성이 가능하다. */
    public static void staticMethod() {

    }

    /* 설명. non-static 메소드도 default 키워드를 사용하면 메소드의 바디부까지 작성이 가능하다  */
    public default void defaultMethod() {

    }

    /* 설명. 접근 제어자가 private인 메소드는 메소드의 바디부까지 작성이 가능하다.(feat. default도 없이) */
    private void privateMethod() {

    }
    /* 설명. 왜 이런 특이 케이스가 생겼을까?
    *   priavate은 이 인터페이스를 구현할 클래스에 물려줄 목적이 아니라 그냥 이 인터페이스 내부에서
    *   사용할 목적이기에(규약의 의미가 없음) 허용하게 했다.
    *   나머지 위 두 개는 그냥 개발자들이 불편하다고 해서 추가해준 거임
    *
    *   설명. 바디가 생겼다?
    *    규약이 아님. 이 인터페이스를 구현하는 입장에서 반드시 재정의 할 필요가 없다는 것.
    *
    *  */
}
