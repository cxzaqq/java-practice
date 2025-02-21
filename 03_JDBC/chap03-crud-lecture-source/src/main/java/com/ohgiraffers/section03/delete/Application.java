package com.ohgiraffers.section03.delete;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.commit;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;
import static com.ohgiraffers.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement ps = null;
        int result = 0;

        /* 설명. soft delete */
//        String query = "UPDATE TBL_MENU SET ORDERABLE_STATUS = 'N' WHERE MENU_CODE = ?";

        /* 설명. hard delete */
        String query = "DELETE FROM TBL_MENU WHERE MENU_CODE = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, 3);
            
            result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("delete 성공");
                commit(con);
            } else {
                System.out.println("delete 실패");
                rollback(con);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
            close(con);
        }
    }
}
