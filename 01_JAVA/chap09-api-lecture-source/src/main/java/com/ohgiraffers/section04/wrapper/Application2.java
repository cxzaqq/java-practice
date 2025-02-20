package com.ohgiraffers.section04.wrapper;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 문자열을 다양한 기본 자료형으로 바꿀 수 있다. */
        byte b = Byte.valueOf("1");
        short s = Short.valueOf("2");
        int i = Integer.valueOf("4");
        long l = Long.valueOf("8");
        float f = Float.valueOf("4.0");
        double d = Double.valueOf("8.0");
        boolean isTrue = Boolean.valueOf("true");
        char c = "abc".charAt(0);                       // Character는 메소드가 제공되지 않아 String의 charAt() 사용

        /* 설명. valueOf보다 parse를 사용하면 더 빠르다 (한 단계 덜 거치기 때문)
        *   코테 풀 때는 parse 쓰자 */
        byte b2 = Byte.parseByte("1");
        short s2 = Short.parseShort("2");
        int i2 = Integer.parseInt("4");
        long l2 = Long.parseLong("8");
        float f2 = Float.parseFloat("4.0");
        double d2 = Double.parseDouble("8.0");
        boolean isTrue2 = Boolean.parseBoolean("true");
        char c2 = "abc".charAt(0);
    }
}
