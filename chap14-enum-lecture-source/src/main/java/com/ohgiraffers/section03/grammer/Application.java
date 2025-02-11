package com.ohgiraffers.section03.grammer;

import java.util.EnumSet;
import java.util.Iterator;

public class Application {
    public static void main(String[] args) {

        UserRole1 admin = UserRole1.ADMIN;
        System.out.println(admin.name());
        System.out.println(admin.getNameToLowerCase());

        UserRole2 consumer = UserRole2.CONSUMER;
        System.out.println(consumer.ordinal());
        System.out.println(consumer.name());
        System.out.println(consumer.getDESCRIPTION());
        System.out.println();

        /* 설명. Set의 개념으로 활용 가능 */
        System.out.println("Set으로 바꿔 반복자 활용");
        EnumSet<UserRole2> roles = EnumSet.allOf(UserRole2.class);
        Iterator<UserRole2> iter = roles.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().name());
        }
    }
}
