package com.ohgiraffers.section01.exception;

public class ExceptionTest {
    public void checkEnoughMoney(int price, int money) throws ArithmeticException {
        System.out.println("you have " + money + "won");

        if(money >= price) {
            System.out.println("enough money to buy product(" + money + "won)");
            return;
        }
//        System.out.println("not enough money to buy product(" + money + "won)");
        
        /* 설명. 예외 상황에 Exception을 상속받는 클래스의 객체를 생성하고 throw로 발생 */
        throw new ArithmeticException("not enough money to buy product(" + money + "won)");
    }
}
