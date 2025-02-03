package com.ohgiraffers.section06.statickeyword;

public class StaticTest {
    private int nonStaticCount;        // 스택에 저장됨
    private static int staticCount;    // 스택에 저장됨

    public StaticTest() {
    }

    public int getNonStaticCount() {
        return nonStaticCount;
    }

    public static int getStaticCount() {
        return staticCount;
    }

    public void increaseNonStaticCount() {
        this.nonStaticCount++;
    }

    public static void increaseStaticCount() {
        StaticTest.staticCount++;
    }
}
