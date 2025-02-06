package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application3 {
    public static void main(String[] args) {
        ExceptionTest2 et = new ExceptionTest2();

        try {
            et.checkEnoughMoney(30000, 10000);

        /* 설명. multi-catch 블록 */
        } catch (PriceNegativeException | MoneyNegativeException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println("기타 다른 모든 예외 처리");
            System.out.println(e.getMessage());
        }

        System.out.println("프로그램을 종료합니다.");
    }
}
