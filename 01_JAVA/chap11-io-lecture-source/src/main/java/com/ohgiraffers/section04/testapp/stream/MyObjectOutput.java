package com.ohgiraffers.section04.testapp.stream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutput extends ObjectOutputStream {
    public MyObjectOutput(OutputStream out) throws IOException {
        super(out);
    }

    /* 설명. 객체를 파일에 입력 시 헤더가 추가되는데 그 헤더를 없애기 위한 재정의
    *   근데 헤더를 없애면 파일의 변화를 인지를 못함.
    *   프로그램을 껐다 키면 재인식이 되긴 함 */
    @Override
    protected void writeStreamHeader() throws IOException {

    }
}
