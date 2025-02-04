package com.ohgiraffers.section01.polymorphism;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표. 다형성을 적용하여 객체 배열을 만들어 다양한 인스턴스들을 연속 처리할 수 있다. */
        /* 설명. 다형성 덕분에 상위 타입으로 배열 생성 가능 */
        Animal[] animals = new Animal[5];
        animals[0] = new Rabbit();
        animals[1] = new Tiger();
        animals[2] = new Rabbit();
        animals[3] = new Tiger();
        animals[4] = new Rabbit();

        for (Animal animal : animals) {
            animal.cry();
            if(animal instanceof Tiger){
                ((Tiger) animal).bite();
            } else if(animal instanceof Rabbit){
                ((Rabbit) animal).jump();
            }
        }
    }
    
}
