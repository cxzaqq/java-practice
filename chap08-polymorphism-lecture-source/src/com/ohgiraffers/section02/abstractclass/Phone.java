package com.ohgiraffers.section02.abstractclass;

public class Phone extends Product {
    /* 설명. 추상 클래스를 상속을 받았는데(new로 생성 불가) 왜 생성자가 동작하는가?
    *   추상 클래스는 객체를 직접 생성할 수 없는 것이지 생성자가 없는 것은 아니다
    *   객체 생성 시 부모 클래스의 초기화가 선행되어야 해서(부모의 필드, 메소드를 사용하기 위해)
    *   추상 클래스를 상속 받은 자식에서는 생성자 호출 가능 */
    public Phone() {
        super();
    }

    /* 설명. 추상 클래스를 상속 받으면 추상 메소드를 무조건 재정의 해야 함 */
    @Override
    public void abstractMethod() {
        System.out.println("Phone에서 Product 추상 메소드 오버라이딩 함");
    }
}
