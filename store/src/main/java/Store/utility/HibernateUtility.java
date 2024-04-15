package Store.utility;

import Store.entity.Customer;
import Store.entity.Product;
import Store.entity.ProductType;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    public static SessionFactory getSessionFactory() {
        //Read the hibernate configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        //Need to add all the entity class into addAnnotationClass.
        configuration.addAnnotatedClass(ProductType.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Customer.class);


        //Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        return sessionFactory;
    }
}
