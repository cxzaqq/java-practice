package com.ohgiraffers.section03.sqlInjection;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application2 {

    private static String empId = "200";
    private static String empName = "' OR 1=1 AND EMP_ID = '200";

    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        /* 설명.
        *   아래 sql과 같이 PreparedStatement는 placeholder로 입력되는 값에 single quotation(')이 있다면
        *   하나 더 붙이고 양 옆에도 추가한다.
        *   이를 통해 SQLInjection 공격을 막게 된다.  */

        // SELECT * FROM EMPLOYEE WHERE EMP_ID = 200 AND EMP_NAME = ''' OR 1=1 AND EMP_ID = ''200'

        try {
            ps = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?");
            ps.setString(1, empId);
            ps.setString(2, empName);

            rs = ps.executeQuery();
            if(rs.next()) {
                System.out.println(rs.getString("EMP_ID") + ", " + rs.getString("EMP_NAME"));
            } else {
                System.out.println("해당 해원은 존재하지 않습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(ps);
            close(con);
        }

    }
}
