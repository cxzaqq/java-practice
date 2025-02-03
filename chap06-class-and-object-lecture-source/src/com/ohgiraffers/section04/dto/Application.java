package com.ohgiraffers.section04.dto;

public class Application {
    public static void main(String[] args) {
        UserDTO user1 = new UserDTO();
        System.out.println(user1.toString());
        System.out.println(user1);

        user1.setId("user1");
        System.out.println(user1.getId());
    }
}
