package com.ohgiraffers.section05.overloading;

public class OverloadingTest {

    /* 수업목표. 오버로딩에 대해 이해할 수 있다. */
    /* 설명.
    *   메소드 시그니처?
    *   메소드의 메소드명, 파라미터 선언부 부분을 메소드의 시그니처(signature)라 함.
    *
    *  설명.
    *   동일한 메소드 이름으로 다양한 종류의 매개변수에 따라 처리해야 하는 경우 적용하는 기술을
    *   오버로딩이라고 한다.
    *
    *  설명.
    *   오버로딩의 조건?
    *   매개변수의 타입, 개수, 순서를 다르게 작성하여 하나의 클래스 내에 동일한 이름의 메소드를
    *   여러 개 작성할 수 있다.
    *   메소드의 헤드부에 있어 시그니처를 제외한 부분이 다르게 작성되는 것은 인정되지 않는다.
    *  */

    public void test() {}

    /* 설명. 반환 타입이 달라도 시그니처(이름, 매개변수(개수, 순서, 타입)가 같으면 같은 것으로 인식 */
//    public String test() {}

    public void teste(int num) {}

    public void test(int num1, int num2) {}

    /* 설명. 매개 변수의 이름은 무의미(같은 메소드로 인식). 타입이 달라야 함 */
//    public void test(int num2, int num1) {}

    public void test(int num, String str) {}

    public void test(String str, int num) {}
}
