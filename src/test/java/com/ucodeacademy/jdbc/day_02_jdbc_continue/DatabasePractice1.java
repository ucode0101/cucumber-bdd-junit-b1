package com.ucodeacademy.jdbc.day_02_jdbc_continue;

import com.ucodeacademy.utility.ConfigReader;
import com.ucodeacademy.utility.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabasePractice1 {
    String url = ConfigReader.getProperty("db.url");
    String dbUsername = ConfigReader.getProperty("db.username");
    String dbPassword = ConfigReader.getProperty("db.password");


    @Test
    public void practice1() throws SQLException {

        DBUtil.createConnection(url,dbUsername,dbPassword);
        ResultSet resultSet = DBUtil.runQuery("select * from employees");

        resultSet.next();

        System.out.println(resultSet.getString("first_name"));


        ResultSetMetaData metaData = resultSet.getMetaData();

        System.out.println(metaData.getColumnCount());

        System.out.println("===================");

        resultSet.first(); // go to first row
        // loop through the resultSet and print each row
        int columCount = metaData.getColumnCount(); // getting number of columns

        while (resultSet.next()){

            for (int i =1; i<=columCount; i++){

                System.out.print(resultSet.getString(i)+" ");

            }
            System.out.println();

        }

        System.out.println("==============================");

        resultSet.first();
        for (int i=1; i< columCount; i++){
            System.out.print(resultSet.getString(i)+" ");
        }




        DBUtil.closeAllConnections();





    }


}
