package com.ohgiraffers.section04.constructor;

public class Application {
    public static void main(String[] args) {
        /* 수업목표. 생성자 함수가 무엇인지 이해하고 선언 및 호출할 수 있다. */
        User user1 = new User();
        System.out.println(user1.information());

        User user2 = new User("u2", "roy2", "roy123");
        System.out.println(user2.information());

        User user3 = new User("u3", "roy3", "roy123", new java.util.Date());
        System.out.println(user3.information());
    }


}
