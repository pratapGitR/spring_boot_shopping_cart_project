package xml_based.execution;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import xml_based.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExecutionForSubject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction tx= null;

        List<Subject> subjects = new ArrayList<>();
        System.out.println("Please Enter 4 subjects");
        for (int i = 0; i < 4; i++) {
            String subName = scanner.nextLine();
            Subject subject = new Subject(subName);
            subjects.add(subject);
        }



        try{
            tx= session.beginTransaction();
            for(Subject sub: subjects){
                session.save(sub);
            }

            tx.commit();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
