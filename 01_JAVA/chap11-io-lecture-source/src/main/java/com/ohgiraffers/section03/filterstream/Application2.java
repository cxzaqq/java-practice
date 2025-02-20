package com.ohgiraffers.section03.filterstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. 표준 입출력(콘솔과의 입출력)을 이해하고 활용할 수 있다. */
        /* 설명. 25.02.07 09:30 ~ 09:35 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("문자열 입력: ");
        try {
            String input = br.readLine();
            System.out.println(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(br != null) br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BufferedWriter bw = null;
        OutputStreamWriter osw = null;
        osw = new OutputStreamWriter(System.out);
        bw = new BufferedWriter(osw);

        try {
            bw.write("println 써야겠지?");
//            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(bw != null) bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
