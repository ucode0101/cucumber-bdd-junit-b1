package com.ucodeacademy.jdbc.day_02_jdbc_continue;

import com.ucodeacademy.utility.ConfigReader;
import org.junit.Test;

import java.sql.*;

public class DatabasePractice4 {
    String url = ConfigReader.getProperty("db.url");
    String username = ConfigReader.getProperty("db.username");
    String password = ConfigReader.getProperty("db.password");


    @Test
    public void insertNewRecord() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        //statement.executeUpdate("delete from employees where employee_id = 101");
        //statement.executeUpdate("UPDATE employees SET first_name ='Jackson' WHERE employee_id = 102");

        // 1. Add a new employee
        statement.executeUpdate("insert into employees (employee_id, first_name,last_name)"+
                "values(01, 'James', 'Bond')");

        ResultSet resultSet = statement.executeQuery("select * from employees order by 1");
        if (resultSet.next()){
            resultSet.next();

            System.out.println("after update");
            System.out.println(resultSet.getString("employee_id"));
            System.out.println(resultSet.getString("first_name"));
            System.out.println(resultSet.getString("last_name"));

        }

        connection.close();
        statement.close();

    }

    @Test
    public void updateTheNewRecord() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username,password);

        Statement statement = connection.createStatement();

        statement.executeUpdate("Update employees SET employee_id = 888 where employee_id=1");

        ResultSet resultSet = statement.executeQuery("select * from employees where employee_id=888");
        if (resultSet.next()){
            System.out.println("after update");
            System.out.println(resultSet.getString("employee_id"));
            System.out.println(resultSet.getString("first_name"));
            System.out.println(resultSet.getString("last_name"));

        }
        connection.close();
        statement.close();

    }

    @Test
    public void deleteAllNewlyAddedRecords() throws SQLException {
        Connection connection = DriverManager.getConnection(url,username,password);

        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE from employees where last_name='Bond'");
    }


}
