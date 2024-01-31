package com.ucodeacademy.jdbc.day_01_jdbc_intro;

import org.junit.Test;

import java.sql.*;

public class DatabasePractice1 {
    String dbUrl = "jdbc:oracle:thin:@18.206.197.33:1521/xepdb1";
    String username = "hr";
    String password = "hr";


    @Test
    public void resultMethodsPractice() throws SQLException {


          Connection connection = DriverManager.getConnection(dbUrl, username,password);
          Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
          ResultSet resultSet = statement.executeQuery("select * from employees");
          // next() -> is used to move the cursor the next row in the resultSet
         resultSet.next();

        //• getString(ColumName) -> retrieves the value of specified column  as a String
        System.out.println(resultSet.getString("first_name"));
        System.out.println(resultSet.getString("job_id"));
        String firstName = resultSet.getString("first_name");
        System.out.println(firstName);

        //• getString(Index) -> retrieves the value of specified column identified by its index as a String
        System.out.println(resultSet.getString(3));
        System.out.println(resultSet.getString(4));
        //• getInt(ColumName) -> retrieves the value of specified column as an int
        System.out.println(resultSet.getInt("employee_id"));
        System.out.println(resultSet.getInt("salary"));

        //• getInt(Index) -> returns/retrieve the values of specified column, identified by its index as an int
        System.out.println(resultSet.getInt(1));
        System.out.println(resultSet.getInt(9));

        //• getDouble(ColumName) -> returns/retrieves the value specified column as a double
        System.out.println(resultSet.getDouble("salary"));

        //• getDouble(Index) -> returns/retrieves the value of specified column, identified by its index as a double
        System.out.println(resultSet.getDouble(1));

        //• getDate(ColumName) -> returns/retrieves the value of specified column as Date (hire_date, history date etc...)
        System.out.println(resultSet.getDate("hire_date"));
        System.out.println(resultSet.getString("hire_date"));
        //• getDate(Index) -> returns/retrieves the value of specified column, identified by its index as Date (hire_date, history date etc...)
        System.out.println(resultSet.getDate(7));


    }

}
