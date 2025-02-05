package com.ohgiraffers.section05.calendar;

import java.text.SimpleDateFormat;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. java.util.Date 클래스 사용법을 이해하고 활용할 수 있다. */
        java.util.Date today = new java.util.Date();
        System.out.println("today: " + today);

        System.out.println("long 타입 시간: " + today.getTime());
        System.out.println("long 타입 시간을 활용한 Date: " + new java.util.Date(0L));
        System.out.println("long 타입 시간을 활용한 Date2: " + new java.util.Date(today.getTime()));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
        String todayFormat = sdf.format(today);
        System.out.println("todayFormat: " + todayFormat);

        /* 설명. java.util.Date -> java.sql.Date */
        java.util.Date today2 = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(today2.getTime()); // long 형으로 바꾼다.

        /* 설명. java.sql.Date -> java.util.Date */
        /* 설명. 이 방향은 자동 형변환이 된다 왜? 다형성이 적용되었기 때문 => sql.Date는 util.Date의 자식이다. */
        java.util.Date today3 = sqlDate;
    }
}
