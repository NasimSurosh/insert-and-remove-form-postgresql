package com.files.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Transaction {
  
  private static Connection connection;
  private static Statement statement;
  
  public static void creatTransaction() throws SQLException {
    connection = DBConnection.getConnection();
    
    try {
      
      statement = connection.createStatement();
      
      
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      if(statement != null) {
        statement.close();
      }
    }
  }
  
  public static void insertTransaction() throws SQLException {
    connection = DBConnection.getConnection();
    try {
      connection.setAutoCommit(false);
    statement = connection.createStatement();
    String creatSta = "insert into table1(2,'Karina', 32)";
    
    statement.executeUpdate(creatSta);
    connection.commit();
    System.out.println("inserted taranssaction");
    
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
  
  public static void main(String[] args) throws SQLException {
    
    DBConnection.getConnection();
    //DataManagement.sqlCreateTable(statement);
    //DataManagement.insertDataIntoTable(statement);
    //DataManagement.dropTable(statement);
    //Transaction.creatTransaction();
    
    DBConnection.closeConnection(connection);
    
    
  }

}
