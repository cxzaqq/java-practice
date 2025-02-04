package com.ohgiraffers.section01.extend;

public class RacingCar extends Car {
    public RacingCar() {
        super();
        System.out.println("RacingCar(자식) 기본 생성자 호출됨..");
    }

    @Override
    public void run() {
        System.out.println("부아아아아아아앙");
    }

    @Override
    public void soundHorn() {
        System.out.println("경적 따위");
    }
}
