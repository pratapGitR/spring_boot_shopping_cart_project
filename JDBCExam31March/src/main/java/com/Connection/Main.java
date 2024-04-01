package com.Connection;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url ="jdbc:mysql://localhost:3306/jdbc_2nd_exam";
        String userName ="root";
        String password = "xxxx@004";
        String createQuery ="create table student(stud_id int(10), stud_name varchar(55), stud_age int(10), stud_dob datetime, primary key(stud_id))";
        String createQuery1 = "create table department(dept_id int(10), dept_name varchar (20),  dept_location varchar (30), stud_id int(10), primary key(dept_id), foreign key (stud_id)references student(stud_id))";
        String createQuery2 ="create table stud_sub_score(sub_id int(10), sub_name varchar(20), sub_score decimal(12,  3), stud_id int(10), primary key(sub_id), foreign key(stud_id) references student(stud_id))";
        String insertQueryStud = "insert into student(stud_id, stud_name, stud_age, stud_dob)values (?,?,?,?)";
        String insertQueryDep ="insert into department (dept_id, dept_name, dept_location, stud_id) values (?,?,?,?)";
        String insertQuerySub ="insert into stud_sub_score (sub_id,sub_name, sub_score,stud_id)values (?,?,?,?)";
        String alterQueryStudentTable= "alter table student add column stud_marks DECIMAL(12, 3)";
        Statement statement = null;
        PreparedStatement studPreparedStatement = null;
        PreparedStatement deptPreparedStatement= null;
        PreparedStatement subPreparedStatement = null;
        CallableStatement callableStatement = null;

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

//            statement.executeUpdate(alterQueryStudentTable);
//            System.out.println("Alter query for student successful");

            //Student table data populate
            int noOfStudent;

            System.out.println("How many student records do you want to insert");
            noOfStudent = scanner.nextInt();
            scanner.nextLine();
            for(int i=1; i<= noOfStudent;i++){
                System.out.println("Enter  Student ID: ");
                int studID = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter Student Name: ");
                String studName = scanner.nextLine();

                System.out.println("Enter student date of birth(YYYY-MM-DD): ");
                String inputDOB= scanner.next();
                LocalDate studDOB = LocalDate.parse(inputDOB);


                LocalDate currentDate = LocalDate.now();
                int studAge = Period.between(studDOB,currentDate).getYears();
                System.out.println("Student Age Calculated is: "+studAge);

                studPreparedStatement = connection.prepareStatement(insertQueryStud);
                studPreparedStatement.setInt(1, studID);
                studPreparedStatement.setString(2, studName);
                studPreparedStatement.setInt(3, studAge);
                studPreparedStatement.setDate(4, Date.valueOf(studDOB));
                studPreparedStatement.executeUpdate();

                System.out.println("***** Now we are entering data in department table ****");
                System.out.println("Enter department ID");
                int deptId = scanner.nextInt();
                scanner.nextLine();
                
                System.out.println("Enter department name");
                String deptName= scanner.nextLine();
                System.out.println("Enter department location");
                String deptLocation = scanner.nextLine();
                System.out.println("StudID is already define so do not need to. refrence from student table studID)");

                deptPreparedStatement = connection.prepareStatement(insertQueryDep);
                deptPreparedStatement.setInt(1, deptId);
                deptPreparedStatement.setString(2, deptName);
                deptPreparedStatement.setString(3, deptLocation);
                deptPreparedStatement.setInt(4, studID);
                deptPreparedStatement.executeUpdate();

                System.out.println("***** Now we are entering data in subject score table ****");
                System.out.println("This is for the Student: "+studName + "whoose id is: "+studID);
                System.out.println("Three are 4 subject so add all subject and their score");
                //since we have for subjects; we can set each sub_id with respective name
                for (int subjectNum=1;subjectNum<=4;subjectNum++){
                    double score;
                    String subjectName;
                    if(subjectNum==1){
                        subjectName = "Maths";
                    }
                    else if(subjectNum==2){
                        subjectName = "History";
                    }
                    else if(subjectNum==3){
                        subjectName = "Geology";

                    }else{
                        subjectName ="English";

                    }
                    System.out.println("Subject ID: " + subjectNum + ", Subject name: " + subjectName);
                    System.out.println("Enter score: ");
                    score = scanner.nextDouble();
                    subPreparedStatement = connection.prepareStatement(insertQuerySub);
                    subPreparedStatement.setInt(1, subjectNum);
                    subPreparedStatement.setString(2, subjectName);
                    subPreparedStatement.setDouble(3, score);
                    subPreparedStatement.setInt(4, studID);
                    subPreparedStatement.executeUpdate();
                }


            }try {
                callableStatement = connection.prepareCall("{call update_student_marks()}");
                callableStatement.execute();
                System.out.println("Stored procedure executed successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (callableStatement != null) {
                        callableStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }





        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(scanner!= null){
                    scanner.close();
                }
                if(connection!= null){
                    connection.close();
                }
                if (studPreparedStatement != null) {
                    studPreparedStatement.close();
                }
                if (deptPreparedStatement != null) {
                    deptPreparedStatement.close();
                }
                if (subPreparedStatement != null) {
                    subPreparedStatement.close();
                }
            }catch (Exception error){
                error.printStackTrace();
            }
        }
    }
}
