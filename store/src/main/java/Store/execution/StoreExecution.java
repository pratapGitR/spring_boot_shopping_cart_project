package Store.execution;

import Store.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Store.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StoreExecution {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction tx= null;

        //Customer
        System.out.println("Enter Customer ID..Enter in Format of C01, C02: " );
        String custId = scanner.nextLine();
        if(!custId.matches("C\\d{2}")){
            throw  new customerIDFormatException("Invalid format");
        }
        System.out.println("Enter customer name");
        String custName= scanner.nextLine();

        System.out.println("Enter customer email");
        String custEmail= scanner.nextLine();

        System.out.println("Enter customer mobile number");
        long custMobile= scanner.nextLong();
        if (String.valueOf(custMobile).length() != 10) {
            throw new IllegalArgumentException("Customer mobile number must be 10 digits.");
        }

        System.out.println("Enter product Id..format P01, P02");
        String productId= scanner.nextLine();



    }

}
