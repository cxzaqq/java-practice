package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 사용자 정의형 예외 클래스 정의 후 발생한 사용자 예외들을 처리할 수 있다. */
        /* 설명.
        *   catch 블럭은 이어서 여러개를 쓸 수 있다.(예외 별 처리를 달리 하고자 할 때)
        *   try 블럭에서 예외가 발생하면 catch 블럭들은 순차적으로 실행되며
        *   이때 부모 예외 클래스가 먼저 작성되면 이후 catch 블럭은 실행되지 않는다.
        *   따라서 자식 예외 클래스를 먼저 작성해야 한다.  */
        ExceptionTest et = new ExceptionTest();

        try {
            et.checkEnoughMoney(30000, 10000);
        } catch (PriceNegativeException e) {
            System.out.println(e.getMessage());
        } catch (MoneyNegativeException e) {
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
