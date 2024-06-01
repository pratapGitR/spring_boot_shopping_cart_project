package com.UserInterface;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseOperation {
    public void DatabaseUpdate(){
        try{
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("database.properties");
            properties.load(fileInputStream);

            String url = properties.getProperty("url");
            String userName =properties.getProperty("userName");
            String password = properties.getProperty("properties");

            Connection connection = DriverManager.getConnection(url,userName,password);
            System.out.println("Connection Successful");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
