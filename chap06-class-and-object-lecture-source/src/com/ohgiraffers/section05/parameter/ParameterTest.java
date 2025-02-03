package com.ohgiraffers.section05.parameter;

import java.util.Arrays;

public class ParameterTest {
    public void testPrimitiveTypeParameter(int num) {
        num = 10;
        System.out.println("매개변수로 전달받아 수정한 값: " + num);
    }

    /* 설명. 참조 주소값을 전달해서 메소드를 호출 시에는 서로 영향. (feat. 반환 필요 없음) */
    public void testPrimitiveArrayTypeParameter(int[] iArr) {
        iArr[0] = 100;
        System.out.println("매개변수로 전달받아 수정한 배열: " + Arrays.toString(iArr));
    }

    public void testClassTypeParameter(Rectangle r) {
        r.calRound();
        r.calArea();
    }

    /* 설명. 가변인자는 넘어온 인자들을 받아내어 배열로 바꿔준다. */
    public void testVariableLengthArrayParameter(String... str) {
        System.out.println("넘어온 인자들 출력: " + Arrays.toString(str));
    }
}
