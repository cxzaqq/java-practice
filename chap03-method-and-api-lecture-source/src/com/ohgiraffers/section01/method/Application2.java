package com.ohgiraffers.section01.method;

public class Application2 {
    public static void main(String[] args) {
        System.out.println("main() 시작함...");
        Application2 app = new Application2();
        app.methodA();
        app.methodB();
        System.out.println("main() 종료함...");
    }

    public void methodA() {
        System.out.println("methodA() 호출됨..");
        System.out.println("methodA() 종료됨..");
    }

    public void methodB() {
        System.out.println("methodB() 호출됨..");
        System.out.println("methodB() 종료됨..");
    }
}
