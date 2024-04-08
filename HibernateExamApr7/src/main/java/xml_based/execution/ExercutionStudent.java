package xml_based.execution;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import xml_based.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExercutionStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx= null;

        System.out.println("Enter student details(name, roll number and Subject Id)");
        System.out.println("Enter number of students you want to add");
        int noOfStd = scanner.nextInt();
        scanner.nextLine();

        List<Student>studentList = new ArrayList<>();
        for (int i = 0; i < noOfStd; i++) {
            System.out.println("Enter student Name");
            String studName= scanner.nextLine();
            System.out.println("Enter Roll Num");
            int studRoll = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Subject id");
            System.out.println("1= Physics, 2= Chemistry, 3=Mathematics, 4= Computer");
            int subId= scanner.nextInt();
            scanner.nextLine();
            Student student = new Student(studName, studRoll, subId);
            studentList.add(student);


            try{
                tx= session.beginTransaction();
                for (Student stud:studentList){
                    session.save(stud);
                }
                tx.commit();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                {
                    if (session != null) {
                        session.close();
                    }
                }

            }
        }

    }
}
