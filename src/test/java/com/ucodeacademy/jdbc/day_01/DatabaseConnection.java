package com.ucodeacademy.jdbc.day_01;

import org.junit.Test;

import java.sql.*;

public class DatabaseConnection {

     String dbUrl = "jdbc:oracle:thin:@18.206.197.33:1521/xepdb1";
     String username = "hr";
     String password = "hr";

     @Test
    public void firstTest() throws SQLException {
         // Creating Connecting to Oracle/hr database
         Connection connection = DriverManager.getConnection(dbUrl, username,password);

         // Creating statement using connection
         Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

         // create result set and store our query result
         ResultSet resultSet = statement.executeQuery("select * from employees");

         resultSet.next();
         System.out.println(resultSet.getString(2));

         // closing all connections
         connection.close();
         statement.close();
         resultSet.next();

     }

     @Test
    public void secondTest() throws SQLException {
         Connection connection = DriverManager.getConnection(dbUrl, username, password);

         Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

         ResultSet resultSet = statement.executeQuery("select * from employees");

         // loop through the resultSet and print first and last name
         while (resultSet.next()){
             System.out.println(resultSet.getString("first_name")+" "+resultSet.getString("last_name"));
         }

         // closing all connections
         connection.close();
         statement.close();
         resultSet.close();
     }
}
