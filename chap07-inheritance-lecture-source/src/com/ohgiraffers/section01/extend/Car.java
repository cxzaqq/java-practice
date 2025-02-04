package com.ohgiraffers.section01.extend;

public class Car /*extends Object*/ {

    private boolean runningStatus;

    public Car() {
        /*super();*/
        System.out.println("Car(부모) 기본 생성자 호출됨...");
    }

    public void soundHorn() {
        if (runningStatus) {
            System.out.println("빵빵");
        } else {
            System.out.println("주행 중이 아니라면 경적을 울릴 수 없습니다.");
        }
    }

    public void run() {
        runningStatus = true;
        System.out.println("Running..");
    }

    public void stop() {
        runningStatus = false;
        System.out.println("Stopped");
    }
}
