package com.files.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManagement {
  
  private static Connection connection;
  private static PreparedStatement ps;
  
  
  public static void sqlCreateTable(Statement statement) throws SQLException {
    connection = DBConnection.getConnection();
    try {
      statement = connection.createStatement();
      String createTabel = "create table if not exists table1("+" id int primary key,"+"name "
          + "varchar(50),"+"age int)";
      
      statement.execute(createTabel);
      System.out.println("Table created successfully!");
      
    }catch(SQLException e) {
      System.out.println(e.getMessage());
    }
    
  }
  public static void insertDataIntoTable(Statement statement) throws SQLException {
    
    connection = DBConnection.getConnection();
    try {
      statement = connection.createStatement();
      String update = "insert into table1 values (1, 'Ahmad', 24)";
      statement.executeUpdate(update);
      
      System.out.println("Data inserted successfully");
      
    }catch(SQLException e) {
      System.out.println(e.getMessage());
    }
    
  }
  public static void dropTable(Statement statement) throws SQLException {
    connection = DBConnection.getConnection();
    try {
      statement = connection.createStatement();
      String drop = "drop table if exists newtable"; 
      
      statement.executeUpdate(drop);
      System.out.println("Table droped successfully!");
    }
    catch(SQLException e) {
      System.out.println(e.getMessage());
    }
  }

}
