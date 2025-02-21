package com.ohgiraffers.section02.update;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.commit;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.common.JDBCTemplate.rollback;

import java.sql.Connection;

public class MenuService {
    public void modifyMenu(Menu menu) {
        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.updateMenu(con, menu);

        if(result == 1) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
    }
}
