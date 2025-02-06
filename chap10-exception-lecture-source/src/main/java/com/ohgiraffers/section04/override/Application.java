package com.ohgiraffers.section04.override;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        SuperClass subClass = new SubClass();

        try {
            subClass.method();
        /* 설명. 타입을 SuperClass로 했기에 컴파일 시 정적 바인딩 된
        *   SuperClass.method()로 인식 => IOException만 처리하면 됨 */
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
