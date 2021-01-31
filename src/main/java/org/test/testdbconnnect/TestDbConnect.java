package org.test.testdbconnnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDbConnect {
  public static void main(String[] args) {
    Connection conn = null;

    String driver = "com.mysql.jdbc.Driver";

    String url = "jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC";

    String username = "root";

    String password = "root";

    try {

      Class.forName(driver);

      conn = DriverManager.getConnection(url, username, password);

      System.out.println("TestConnectionByJDBC success");

      conn.close();

    } catch (ClassNotFoundException | SQLException e) {

      e.printStackTrace();

    }

  }
}
