package com.ohgiraffers.section02.update;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MenuRepository {
    public int updateMenu(Connection con, Menu menu) {
        PreparedStatement ps = null;
        int result = 0;

        Properties prop = new Properties();
        try {
            prop.loadFromXML(
                    new FileInputStream(
                            "src/main/java/com/ohgiraffers/section01/insert/mapper/menu-mapper.xml"
                    )
            );
            String query = prop.getProperty("updateMenu");
            ps = con.prepareStatement(query);
            ps.setString(1, menu.getMenuName());
            ps.setInt(2, menu.getMenuPrice());
            ps.setInt(3, menu.getMenuCode());

            result = ps.executeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
