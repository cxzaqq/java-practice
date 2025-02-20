package com.ohgiraffers.section01.polymorphism;

public class Rabbit extends Animal {
    @Override
    public void eat() {
        System.out.println("Rabbit 풀 냠냠");
    }

    @Override
    public void run() {
        System.out.println("Rabbit 깡총");
    }

    @Override
    public void cry() {
        System.out.println("Rabbit 끼익");
    }

    public void jump() {
        System.out.println("Rabbit 짬뿌~!");
    }
}
