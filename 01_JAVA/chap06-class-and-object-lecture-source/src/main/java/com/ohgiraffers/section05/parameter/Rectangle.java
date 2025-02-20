package com.ohgiraffers.section05.parameter;

public class Rectangle {
    private int height;
    private int width;

    public Rectangle() {
    }

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void calArea() {
        System.out.println("Area of Rectangle: " + (height * width));
    }

    public void calRound() {
        System.out.println("Round of Rectangle: " + ((height + width) * 2));
    }
}
