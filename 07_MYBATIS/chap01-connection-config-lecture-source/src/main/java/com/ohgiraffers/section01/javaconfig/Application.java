package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    private static String  driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3307/menudb";
    private static String user = "swcamp";
    private static String password = "swcamp";

    public static void main(String[] args) {
        
        /* 설명.
         *  JdbcsTransactionFactory: 수동 커밋
         *  ManagedTransactionFactory: 자동 커밋
         *  -----------------------------------
         *  PooledDataSource: ConnectionPool 사용 (Connection 객체를 미리 생성 후 할당)
         *   => hikaricp(Sprign Boot에 내장된 상향된 ConnectionPool)
         *  UnPooledDataSource: ConnectionPool 미사용
        * */
        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver, url, user, password)
        );

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(Mapper.class);

        /* 설명. 
        *   SqlSessionFactory: SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        *   SqlSessionFactoryBuilder: SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할
        *   build(): 설정에 대한 정보를 담고 있는 Configuration 타입의 객체(java 방식) 혹은 외부 설정 파일과 연결된
        *   stream을 매개변수로 전달(xml 방식)하면 SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드 */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session = sqlSessionFactory.openSession(false); // false를 작성해야 수동 커밋 완성

        Mapper mapper = session.getMapper(Mapper.class);

        java.util.Date date = mapper.selectNow();
        System.out.println("date = " + date);

        session.close();
    }
}
