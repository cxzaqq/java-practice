package com.ohgiraffers.section04.wrapper;

public class Application3 {
    public static void main(String[] args) {
        /* 설명. byte, short는 수를 int로 인식하기에 강제 타입 변환 필요
        *    */
        String b = Byte.valueOf((byte)1).toString();
        String s = Short.valueOf((short)2).toString();
        String i = Integer.valueOf(4).toString();
        String l = Long.valueOf(8L).toString();
        String f = Float.valueOf(4.0f).toString();
        String d = Double.valueOf(8.0).toString();
        String isTrue = Boolean.valueOf(true).toString();
        String ch = Character.valueOf('a').toString();

        /* 설명. 위가 정석이지만 보통 아래로 많이 쓴다 */
        String byteStr = (byte)1 + "";
    }
}
