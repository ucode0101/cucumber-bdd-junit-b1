package com.ucodeacademy.jdbc.day_01_jdbc_intro;

import org.junit.Test;

import java.sql.*;

public class DatabasePractice2 {
    String dbUrl = "jdbc:oracle:thin:@54.152.93.91:1521/xepdb1";
    String username = "hr";
    String password = "hr";

    @Test
    public void nextPreviousFirstLast() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select * from employees order by employee_id");

        resultSet.next(); // -> next() is used to move the cursor to the next row in the resultSet
        System.out.println(resultSet.getString("first_name"));

        resultSet.next();  // -> next() is used to move the cursor to the next row in the resultSet
        System.out.println(resultSet.getString("first_name"));

        resultSet.next();  // -> next() is used to move the cursor to the next row in the resultSet
        System.out.println(resultSet.getString("first_name"));

        resultSet.previous(); // is used to move the cursor the previous row in the resultSet
        System.out.println(resultSet.getString("first_name"));

        resultSet.next();
        System.out.println(resultSet.getString("first_name"));

        resultSet.first(); // is used to move the cursor to the first row in the resultSet (from any row/anywhere)

        System.out.println(resultSet.getString("first_name"));

        resultSet.last(); // is used to move the cursor to the last row in the resultSet (from any row/anywhere)
        System.out.println(resultSet.getString("first_name"));
        statement.close();
        connection.close();
        resultSet.close();


    }

}
