package com.ohgiraffers.section04.wrapper;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. Wrapper 클래스에 대해 이해할 수 있다. */
        int intValue = 20;

        /* 설명. 기본자료형을 Wrapper 클래스 자료형으로 변환할 수 있다. */
        Integer autoBoxingInt = 20;                                 // auto boxing
        Integer boxingInt = Integer.valueOf(intValue);              // 명시적 boxing

        /* 설명. Wrapper 클래스 자료형을 기본자료형으로 변환할 수 있다. */
        int autoUbnoxingInt = autoBoxingInt;                        // auto unboxing
        int ubboxingInt = boxingInt.intValue();                     // 명시적 unboxing

        /* 설명. Object 타입에 원시 타입 20이 어떻게 담기는가?
        *   auto boxing이 발생해서 Integer가 되고 다형성에 의해(부모가 Object) 대입 가능 */
        anythingMethod(20);
        System.out.println();

        /* 설명. Wrapper 클래스 주소값 비교 */
        Integer integerTest = 30;
        Integer integerTest2 = 30;

        /* 설명. 모두 같다고 나오는데 Integer 및 모든 Wrapper 클래스들 또한 new로 생성하지 않으면 constant pool을 사용하기 때문 */
        System.out.println("== 비교: " + (integerTest == integerTest2));
        System.out.println("equals() 비교: " + integerTest.equals(integerTest2));
        System.out.println("IntegerTest 주소: " + System.identityHashCode(integerTest));
        System.out.println("IntegerTest2 주소: " + System.identityHashCode(integerTest2));

    }

    private static void anythingMethod(Object obj) {
        /* 설명. Integer.toString() (동적바인딩)이 실행되어 Integer 객체지만 값이 출력됨 */
        System.out.println("obj: " + obj);
    }
}
