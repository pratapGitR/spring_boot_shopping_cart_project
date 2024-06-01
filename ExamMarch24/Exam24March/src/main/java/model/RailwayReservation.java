package model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class RailwayReservation {
    private String passsengerName;
    private Integer passengerAge;
    private Integer choosenSeat;
    private String typeOfReservation;
    private Integer amountPaid;
     private boolean isSeniorCitizen;

    public RailwayReservation(String passsengerName, Integer passengerAge, Integer choosenSeat, String typeOfReservation) {
        this.passsengerName = passsengerName;
        this.passengerAge = passengerAge;
        this.choosenSeat = choosenSeat;
        this.typeOfReservation = typeOfReservation;
        this.isSeniorCitizen = passengerAge>60;
        calculateAmountPaid();
    }

    private void calculateAmountPaid(){
        if(typeOfReservation.equalsIgnoreCase("AC")){
            amountPaid =100;
        }else{
            amountPaid =60;
        }
    }
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

            String createQuery ="create table railway_reservation";

            Statement statement = connection.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
