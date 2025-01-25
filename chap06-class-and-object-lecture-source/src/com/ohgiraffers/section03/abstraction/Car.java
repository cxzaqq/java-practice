package com.ohgiraffers.section03.abstraction;

public class Car {
    private boolean isOn = false;
    private int speed;
    
    public void startUp() {
        if(this.isOn) {
            System.out.println("이미 시동이 걸려 있습니다.");
        } else {
            this.isOn = true;
            System.out.println("시동을 걸었습니다. 부릉부릉");
        }
    }

    public void go() {
        if(this.isOn) {
            this.speed += 10;
            System.out.println("전진 중.. 현재 속도: " + this.speed);
        } else {
            System.out.println("시동을 먼저 걸어주세요.");
        }
    }

    public void stop() {
        if(this.isOn) {
            if(speed > 0) {
                speed = 0;
                System.out.println("급 브레이크 끼이익");
            } else {
                System.out.println("이미 멈춰 있습니다.");
            }
        } else {
            System.out.println("시동을 먼저 걸어주세요.");
        }
    }

    public void turnOff() {
        if (this.isOn) {
            if (speed > 0) {
                System.out.println("달리는 중에는 시동을 끌 수 없습니다. 차를 멈추세요.");
            } else {
                this.isOn = false;
                System.out.println("시동이 꺼졌습니다.");
            }
        } else {
            System.out.println("이미 시동이 꺼져 있습니다.");
        }
    }
}
