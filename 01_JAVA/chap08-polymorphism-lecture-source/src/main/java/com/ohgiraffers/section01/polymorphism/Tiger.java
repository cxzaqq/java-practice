package com.ohgiraffers.section01.polymorphism;

public class Tiger extends Animal {
    @Override
    public void eat() {
        System.out.println("Tiger 고기 냠냠");
    }

    @Override
    public void run() {
        System.out.println("Tiger 품위 없게 뛰지 않는다.");
    }

    @Override
    public void cry() {
        System.out.println("Tiger 어흥");
    }

    public void bite() {
        System.out.println("Tiger 콰득");
    }
}
