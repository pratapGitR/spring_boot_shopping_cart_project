package com.UserInterface;

import model.RailwayReservation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Passenger Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Passenger Age: ");
        Integer age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Choosen Seat Number");
        Integer seat = scanner.nextInt();
        System.out.println("Enter type of Reservation (AC or Non-AC)");
        String typeOfRes = scanner.nextLine();

        RailwayReservation railwayReservation = new RailwayReservation(name, age, seat, typeOfRes);
        reservation.updateDatabase();

        scanner.close();

    }
    private static  void createTable(){
        try{
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("database.properties");
            properties.load(fileInputStream);

            String url = properties.getProperty("url");
            String userName =properties.getProperty("userName");
            String password = properties.getProperty("properties");

            Connection connection = DriverManager.getConnection(url,userName,password);
            System.out.println("Connection complete ");

//            Statement statement =null;
//            statement = connection.createStatement()

        }catch (Exception e){
            System.out.println("Error ");
            e.printStackTrace();
        }
    }
}
