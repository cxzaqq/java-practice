package com.ohgiraffers.section03.uses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 예외 처리를 많이 사용하는 io 패키지와 관련된 try-catch 구문을 이해할 수 있다. */
        /* 설명.
         *  예외 처리를 가장 많이 사용하게 되는 상황(io 패키지 관련)에서 try-catch 구문을 실제 상황과
         *  유사하게 연습해 보자.
         *  (아직 배우지 않았으나 입출력 관련 구문을 하나하나 신경쓰기 보다는 전체 흐름과 구조를 신경쓰자.)
        * */
        /* 설명. new File은 파일이 생성되는 게 아니라 test.dat 파일의 File이라는 자바 객체를 만드는 것 */
        System.out.println(new File("test.dat").getAbsolutePath());

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(new File("test.dat")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

            /* 설명.
             *  예외처리 구문과 상관 없이 반드시 수행해야 하는 경우 finally에 작성하는데
             *  보통 사용한 자원을 반납하는 용도로 사용한다.
            * */
            try {
                if(br != null) {
                    /* 설명.
                     *  입출력에서 사용한 스트림(통로)을 닫아주는 용도의 메소드.
                     *  스트림이 없을 때(null)를 고려하고 IOException을 처리해야 제대로 할 수 있다.
                    * */
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
