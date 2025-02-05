package com.ohgiraffers.section01.array;

public class Application5 {
    public static void main(String[] args) {
        String[] name = {"SPADE", "CLOVER", "HEART", "DIAMOND"};
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "JACK", "QUEEN", "KING"};

        int randomNameIndex = (int) (Math.random() * name.length);
        int randomNumberIndex = (int) (Math.random() * numbers.length);

        System.out.println(name[randomNameIndex]);
        System.out.println(numbers[randomNumberIndex]);
    }
}
