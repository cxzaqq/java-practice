package com.ohgiraffers.section02.extend.vo;

/* 설명. Rabbit혹은 Rabbit을 상속 받은 클래스만 사용 가능 */
public class RabbitFarm<T extends Rabbit> {
    private T rabbit;

    public RabbitFarm() {
    }

    public RabbitFarm(T rabbit) {
        this.rabbit = rabbit;
    }

    public T getRabbit() {
        return rabbit;
    }

    public void setRabbit(T rabbit) {
        this.rabbit = rabbit;
    }
}
