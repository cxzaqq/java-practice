package com.ohgiraffers.section01.generic;

public class Application {
    public static void main(String[] args) {
        /* 수업목표. generic에 대해 이해할 수 있다. */
        MyGenericTest mgt = new MyGenericTest();

        /* 설명. 구현의 편리성은 높지만 타입의 안정성이 불안하다. */
        mgt.setValue("Hello World");
        mgt.setValue(1);
        mgt.setValue(3.14);
        mgt.setValue(new java.util.Date());

        System.out.println(mgt.getValue());
        // 에러도 안 뜸. 런타임에 예외가 터짐
        double dnum = (Double)mgt.getValue();
        
        
//        GenericTest<Integer> gt1 = new GenericTest<Integer>();
        GenericTest<Integer> gt1 = new GenericTest<>(); // 생략 가능
        gt1.getValue(); // 다이아몬드 연산자 안의 참조 자료형을 반환하게 되는 것을 확인 가능
        gt1.setValue(1); // 타입의 안정성이 높다!(다이아몬드 연산자 안 참조자료형을 위반하지 않는다)

        /* 설명.
        *   제네릭 클래스는 다양한 자료형으로 변할 수 있어 클래스 하나만으로 활용가치가 높아진다.(구현의 편의성)
        *   매개변수나 반환형도 제네릭 타입으로 지정되어 명확히 해당 타입에 대해 처리할 수 있다.(타입의 안정성) */
    }
}
