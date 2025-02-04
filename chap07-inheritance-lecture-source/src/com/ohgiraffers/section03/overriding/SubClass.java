package com.ohgiraffers.section03.overriding;

public class SubClass extends SuperClass {
    public SubClass() {
        super();
    }
    
    /* 설명. 부모 메소드의 헤드부와 일치하게 오버라이딩 */
//    @Override
//    public void method(int num) {}

    /* 설명. 메소드 이름 변경(새로운 메소드를 생성한 샘) */
//    @Override
//    public void method1(int num) {}

    /* 설명. 메소드의 반환형(리턴 타입) 변경 */
//    @Override
//    public String method(int num) {
//        return null;
//    }

    /* 설명. 경우에 따라서는 메소드와 반환형을 달리 해도 오버라이딩 가능
    *   이유. 부모가 Object 반환 시(Object는 모든 클래스의 부모이기에) */
    @Override
    public String method2(int num) {
        return null;
    }

    /* 설명. 부모의 private은 오버라이딩 불가 */
//    @Override
//    private void privateMethod() {}

    /* 설명. 부모의 final은 public이어도 오버라이딩 불가 */
//    @Override
//    public final void finalMethod() {}

    /* 설명. 다른 패키지더라도 상속관계이므로 오버라이딩 가능 */
    @Override
    protected void protectedMethod() {}
//    public void protectedMethod(); // 더 큰 범위로 접근 제어자를 변경 가능
    
    /* 설명. 다른 패키지면 오버라이딩 불가 */
    @Override
    void defaultMethod() {} // 현재는 같은 패키지
}
