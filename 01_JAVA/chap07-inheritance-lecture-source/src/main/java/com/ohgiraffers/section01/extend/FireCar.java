package com.ohgiraffers.section01.extend;

public class FireCar extends Car {
    public FireCar() {
        super();
        System.out.println("FireCar(자식) 기본 생성자 호출됨..");
    }

    public void sprayWater() {
        System.out.println("Spraying water ===========3");
    }

    @Override
    /* 설명.
    *   @Override 어노테이션을 사용하는 이유?
    *   1. 메소드 중에 부모로부터 물려받아 재정의 하는 메소드를 파악하기 용이하도록 하기 위해(가독성)
    *   2. 부모의 메소드를 오버라이딩할 때 발생할 수 있는 실수를 방지
    *  */
    public void soundHorn() {
        System.out.println("빠아아아아아아앙!!!!!!");
    }
}
