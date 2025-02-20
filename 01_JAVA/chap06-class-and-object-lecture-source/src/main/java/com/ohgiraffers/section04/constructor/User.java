package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class User {
    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    /* 설명. 기본 생성자(매개변수가 없는)를 활용한 객체 생성
    *   안 적으면 컴파일 시 자동으로 적어주지만 반드시 명시적으로 쓰자 */
    public User() {
        System.out.println("기본 생성자 호출");
    }

    /* 설명. 명시적으로 생성자를 작성하면 기본 생성자는 자동으로 생성되지 않는다. */
    /* 설명. 원하는 필드를 초기화 하기 위한 매개변수 있는 생성자를 활용해 객체를 생성할 수 있다. */
    public User(String id, String pwd, String name) {
        System.out.println("매개변수 있는 생성자 호출");

        /* 설명. 생성자 내의 this.은 이 생성자로 만들어질 객체에 접근하는 것이다. */
        /* 설명. this를 붙이지 않으면 매개 변수의 이름과 같기에 지역 변수로 인식한다.
        *   생성자 내부에서는 꼭 this를 붙이자 */
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    /* 설명. Date는 두 가지가 있기에 보통 java.util.Date 이렇게 풀네임을 보통 사용한다.  */
    public User(String id, String pwd, String name, java.util.Date enrollDate) {
//        this.id = id;
//        this.pwd = pwd;
//        this.name = name;

        /* 설명. 중복을 줄이기 위해 같은 클래스 내의 다른 생성자를 호출할 수 있다. */
        /* 설명. this()는 항상 첫 줄에 작성되어야 하며 2개 이상 작성할 수 없다. */
        this(id, pwd, name);
        this.enrollDate = enrollDate;
    }

    public String information() {
        return "id: " + this.id + ", pwd: " + this.pwd + ", name: " + this.name + ", enrollDate: " + this.enrollDate;
    }


}
