package Store.execution;

import Store.entity.ProductType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class productTypeExecution {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(ProductType.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction tx= null;
        try {


            ProductType productType1 = new ProductType();
            productType1.setProductType("grocery");
            productType1.setRateOfProduct(30.00);

            ProductType productType2 = new ProductType();
            productType2.setProductType("cosmatic");
            productType2.setRateOfProduct(50.00);

            ProductType productType3 = new ProductType();
            productType3.setProductType("dairy product");
            productType3.setRateOfProduct(35.00);

            tx= session.beginTransaction();
            session.save(productType1);
            session.save(productType2);
            session.save(productType3);
            tx.commit();


        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
