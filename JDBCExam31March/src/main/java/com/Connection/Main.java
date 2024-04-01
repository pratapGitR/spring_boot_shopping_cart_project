package com.Connection;

import org.apache.xmlbeans.GDate;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url ="jdbc:mysql://localhost:3306/jdbc_2nd_exam";
        String userName ="root";
        String password = "WorkIsLife@004";
        String createQuery ="create table student(stud_id int(10), stud_name varchar(55), stud_age int(10), stud_dob datetime, primary key(stud_id))";
        String createQuery1 = "create table department(dept_id int(10), dept_name varchar (20),  dept_location varchar (30), stud_id int(10), primary key(dept_id), foreign key (stud_id)references student(stud_id))";
        String createQuery2 ="create table stud_sub_score(sub_id int(10), sub_name varchar(20), sub_score decimal(12,  3), stud_id int(10), primary key(sub_id), foreign key(stud_id) references student(stud_id))";
        String insertQueryStud = "insert into student(?,?,?,?)";
        String insertQuesyDep ="insert into department(?,?,?,?)";
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,userName,password);
            System.out.println("Connection Successful!! ");

            statement = connection.createStatement();
//            statement.execute(createQuery);          //create table student.
//            System.out.println("Table create");
//            statement.executeUpdate(createQuery1);            //create table department.
//            System.out.println("dept table created");
//            statement.execute(createQuery2);                    //create table stud_sub_score.
//            System.out.println("stud_sub_score table created!");

            //Student table data populate
            int noOfStudent;



            preparedStatement = connection.prepareStatement(insertQueryStud);
            System.out.println("How many student records do you want to insert");
            noOfStudent = scanner.nextInt();
            for(int i=1; i<= noOfStudent;i++){
                System.out.println("Enter  Student ID: ");
                int studID = scanner.nextInt();

                System.out.println("Enter Student Name: ");
                String studName = scanner.next();


                System.out.println("Enter student date of birth(YYYY-MM-DD): ");
                String inputDOB= scanner.nextLine();
                LocalDate studDOB = LocalDate.parse(inputDOB);

                System.out.println("Student Age Calculated is: ");
                LocalDate currentDate = LocalDate.now();
                int studAge = Period.between(studDOB,currentDate).getYears();

                preparedStatement.setInt(1, studID);
                preparedStatement.setString(2, studName);
                preparedStatement.setInt(3, studAge);
                preparedStatement.setDate(4, Date.valueOf(studDOB));


            }





        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
