package com.ucodeacademy.jdbc.day_02_jdbc_continue;

import com.ucodeacademy.utility.ConfigReader;
import org.junit.Test;

import java.sql.*;

public class DatabasePractice2 {

    String url = ConfigReader.getProperty("db.url");
    String username = ConfigReader.getProperty("db.username");
    String password = ConfigReader.getProperty("db.password");

    // Count how many NULL values are there in Employees table
    @Test
    public void countNullValues() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY  );
        ResultSet resultSet = statement.executeQuery("select * from employees");

//        ResultSetMetaData metaData = resultSet.getMetaData();

        int columnCount = resultSet.getMetaData().getColumnCount();
        int countNulls =0;

        while (resultSet.next()){
            for (int i =1; i< columnCount; i++){
                if (resultSet.getString(i) == null){
                    countNulls++;
                    System.out.println(resultSet.getString(2));
                }

            }
        }
        System.out.println("Number of NULL values: "+countNulls);
    }
}
