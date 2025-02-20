package com.ohgiraffers.section03.uses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application2 {
    public static void main(String[] args) {
        
        /* 수업목표. try-with-resource 구문을 이해하고 활용할 수 있다.(feat finally 미사용) */
        /* 설명. br.close()를 안 해도 이렇게 작성하면 자동으로 됨 */
        try (BufferedReader br = new BufferedReader(new FileReader("test.dat"))) {
            // 구조만 보자
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
