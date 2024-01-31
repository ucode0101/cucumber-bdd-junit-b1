package com.ucodeacademy.utility;

import java.sql.*;

public class DBUtil {

    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;


    public static Connection createConnection(String url, String username,String password){
        try {
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e){
            e.getStackTrace();
            throw new RuntimeException("Connection failed, please check your credentials and url");
        }

        return connection;


    }
    public static ResultSet runQuery(String query){
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);
        } catch (SQLException e){
            e.getStackTrace();
        }


        return resultSet;
    }

    public static void closeAllConnections(){
        try {
            if (connection !=null){
                connection.close();
            }
            if (statement !=null){
                statement.close();
            }
            if (resultSet !=null){
                resultSet.close();
            }
        }
        catch (SQLException e){
            e.getStackTrace();
        }
    }
}
