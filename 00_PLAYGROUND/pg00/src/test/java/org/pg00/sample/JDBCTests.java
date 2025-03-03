package org.pg00.sample;


import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.jupiter.api.Test;

public class JDBCTests {

    @Test
    public void testConnection() throws Exception {

        //DB Driver Class
        Class.forName("org.mariadb.jdbc.Driver");

        //URL
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3307/springdb", "springdbuser", "springdbuser");

        System.out.println(connection);
        //username/password

        connection.close();
    }
}
