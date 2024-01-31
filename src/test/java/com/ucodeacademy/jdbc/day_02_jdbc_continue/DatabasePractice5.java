package com.ucodeacademy.jdbc.day_02_jdbc_continue;

import com.ucodeacademy.utility.ConfigReader;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePractice5 {
    String url = ConfigReader.getProperty("db.url");
    String username = ConfigReader.getProperty("db.username");
    String password = ConfigReader.getProperty("db.password");

    @Test
    public void createNewTable() throws SQLException {

        Connection connection = DriverManager.getConnection(url,username, password);

        Statement statement = connection.createStatement();
        statement.executeUpdate("""
                create table testTable(
                 test_id NUMBER(10) PRIMARY KEY,
                 test_name VARCHAR2(30)
                
                )
                """);


    }

    @Test
    public void dropNewlyCreatedTable() throws SQLException {
        Connection connection = DriverManager.getConnection(url,username, password);

        Statement statement = connection.createStatement();

        statement.executeUpdate("drop table testTable");
    }
}
