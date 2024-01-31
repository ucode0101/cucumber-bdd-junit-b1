package com.ucodeacademy.jdbc.day_02_jdbc_continue;

import com.ucodeacademy.utility.ConfigReader;
import org.junit.Test;

import java.sql.*;

public class DatabasePractice3 {
    String url = ConfigReader.getProperty("db.url");
    String username = ConfigReader.getProperty("db.username");
    String password = ConfigReader.getProperty("db.password");

    @Test
    public void practiceDatabaseMetaData() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username,password);

        DatabaseMetaData databaseMetaData = connection.getMetaData();

        System.out.println(databaseMetaData.getConnection());
        System.out.println(databaseMetaData.getMaxColumnsInIndex());
        System.out.println(databaseMetaData.getDriverName());
        System.out.println(databaseMetaData.allTablesAreSelectable());

        System.out.println(databaseMetaData.getUserName());

        System.out.println(databaseMetaData.getDatabaseProductName());
        System.out.println(databaseMetaData.getDatabaseProductVersion());


    }
}
