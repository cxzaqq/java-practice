package com.ohgiraffers.section01.polymorphism;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 다형성과 타입 형변화에 대해 이해할 수 있다. */
        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.cry();
        System.out.println();

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite();
        System.out.println();

        Rabbit rabbit = new Rabbit();
        rabbit.eat();
        rabbit.run();
        rabbit.cry();
        rabbit.jump();
        System.out.println();

        /* 설명. 동적 바인딩?
        *   컴파일 당시에는 해당 타입의 메소드와 연결되어 있다가
        *   런타임 시 실제 객체가 가진 오버라이딩 된 메소드로 바인딩 되어 바뀌어 동작하는 것
        *   (조건: 상속, 다형성, 오버라이딩) */
        Animal an1 = new Animal();
        Animal an2 = new Tiger(); // 다형성
        an2.eat(); // Animal 타입이지만 Tiger.eat()이 실행됨. 이게 동적 바인딩
        an2.run();
        an2.cry();
//        an2.bite(); // 불가
        System.out.println();

        Animal an3 = new Rabbit(); // 다형성
        an3.eat();
        an3.run();
        an3.cry();
//        an3.jump(); // 불가
        System.out.println();

        /* 설명. 부모 타입을 강제로 자식 타입으로 변환이 가능(주의 필요) */
        ((Tiger)an2).bite();
//        ((Rabbit)an2).jump(); // 코드에서는 에러가 안 뜨지만 실행 시에 에러가 뜸
        /* 설명. 런타임 에러를 막기 위해 instanceof 사용 */
        if(an2 instanceof Tiger) {
            ((Tiger)an2).bite();
        }
        if(an3 instanceof Rabbit) {
            ((Rabbit)an3).jump();
        }

        if(an3 instanceof Animal) {
            System.out.println("Animal도 맞지");
        }
    }
}
