package com.files.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
  
  private static final String user = "postgres";
  private static final String pwd = "Nasim646016";
  private static final String url = "jdbc:postgresql://localhost:5432/test";
  
  public static Connection getConnection() throws SQLException {
    Connection connection = DriverManager.getConnection(url, user, pwd);
    return connection;
    
  }
  
  public static void closeConnection(Connection connection) {
    try {
      if(connection != null && !connection.isClosed()) {
        connection.close();
      }
    }catch(SQLException e) {
      System.out.println(e.getMessage());
    }
  }

}
