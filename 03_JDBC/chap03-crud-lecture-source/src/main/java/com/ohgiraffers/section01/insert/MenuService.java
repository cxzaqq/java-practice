package com.ohgiraffers.section01.insert;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.commit;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.common.JDBCTemplate.rollback;

import java.io.FileNotFoundException;
import java.sql.Connection;

/* 설명. Service 계층은 Connection 객체 생성 및 소멸(close) 및 비즈니스 로직, 트랜잭션(커밋, 롤백) 처리 */
public class MenuService {

    public void registMenu(Menu menu) {

        /* 설명. Connection 객체는 메소드 내부에서 생성하고 소멸한다. (요쳥별/트랜잭션별) */
        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = 0;
        result = repository.insertMenu(con, menu);

        /* 설명. JDBCTemplate에 메소드 추가 */
        if (result == 1) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }
}
