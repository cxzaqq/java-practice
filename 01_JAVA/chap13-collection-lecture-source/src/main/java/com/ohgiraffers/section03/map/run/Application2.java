package com.ohgiraffers.section03.map.run;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표. Properties에 대해 이해하고 활용할 수 있다. */
        /* 설명.
        *   Properties란?
        *   HashMap과 거의 유사하지만 key와 value 모두 String으로만 사용할 수 있는 자료구조.(제네릭 별도 요구 X)
        *   주로 설정과 관련된 파일과의 입출력에 사용된다.(store, load 등)
        *   설정은 .java가 아닌 외부 파일로 저장하는데 그 이유는
        *   1. 수정이 용이(java를 jar(압축 파일)로 만드는 데 오래 걸림)
        *   2. 비개발자도 수정할 수 있게*/
        Properties prop = new Properties();

        prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
        prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:XE");
        prop.setProperty("user", "swcamp");
        prop.setProperty("password", "swcamp");

        System.out.println("prop: " + prop);

        try {
            prop.store(new FileOutputStream("driver.dat"), "jdbc driver");
            /* 설명. XML? extensible markup language
            *   태그를 커스텀 가능 */
            prop.storeToXML(new FileOutputStream("driver.xml"), "jdbc driver xml version");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* 설명. 출력으로 내보낸 파일을 읽어서 새로운 Properties에 담기 */
        Properties prop2 = new Properties();
        System.out.println("before read: " + prop2);

        try {
//            prop2.load(new FileInputStream("driver.dat"));
            prop2.loadFromXML(new FileInputStream("driver.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("====== after read ======");
        System.out.println("driver: " + prop2.getProperty("driver"));
        System.out.println("url: " + prop2.getProperty("url"));
        System.out.println("user: " + prop2.getProperty("user"));
        System.out.println("password: " + prop2.getProperty("password"));
    }
}
