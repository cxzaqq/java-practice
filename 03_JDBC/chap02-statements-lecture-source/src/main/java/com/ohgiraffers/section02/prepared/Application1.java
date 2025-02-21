package com.ohgiraffers.section02.prepared;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();

        /* 설명. Statement보다 캐싱을 활용해 실행 속도가 더 빠르다.(최초 실행 이후) */
        PreparedStatement pstmt = null;
        ResultSet rset= null;

        try {
            /* 설명. Statement와 달리 PreparedStatement는 생성 당시에 쿼리가 있어야 한다. */
            pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");
            rset = pstmt.executeQuery();

            while(rset.next()) {
                System.out.println(rset.getString("EMP_ID")
                + ", " + rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
