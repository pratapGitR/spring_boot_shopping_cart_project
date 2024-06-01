package Store.execution;

import Store.entity.Customer;
import Store.entity.Product;
import Store.entity.ProductType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.Scanner;

public class StoreExecution {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(ProductType.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction tx= null;

        //Customer
        System.out.println("Enter Customer ID..Enter in Format of C01, C02: " );
        String custId = scanner.nextLine();
        validCustId(custId);

        System.out.println("Enter customer name");
        String custName= scanner.nextLine();

        System.out.println("Enter customer email");
        String custEmail= scanner.nextLine();

        System.out.println("Enter customer mobile number");
        long custMobile= scanner.nextLong();
        scanner.nextLine();
        validCustMobile(custMobile);


        //Product insertion
        System.out.println("Enter product Id..format P01, P02");
        String productId= scanner.nextLine();
        validProdId(productId);

        System.out.println("Enter product name: ");
        String productName= scanner.nextLine();

        System.out.println("Enter product quantity: ");
        Double productQuantity= scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter the type of product (Grocery / cosmetics/ dairy product)");
        String productType = scanner.nextLine();

        double rate = getR(productType,session);

    }
    static void validCustId(String custId){
        if(!custId.matches("C\\d{2}")){
            throw new IllegalArgumentException("Invalid customer Id format!!(please enter in format of C01,C02..)")
        }
    }
    static  void validCustMobile(Long custMobile){
        if(String.valueOf(custMobile).length()!= 10){
            throw new IllegalArgumentException("Invalid phone number length.. enter 10 digits !!");
        }
    }
    static void validProdId(String custId){
        if(!custId.matches("P\\d{2}")){
            throw new IllegalArgumentException("Invalid product Id format!!(please enter in format of P01,P02..)")
        }
    }
    static  Double getProductRate(String productType, Session session){
        String query ="From product_type where product_type= :type";
    }

}
