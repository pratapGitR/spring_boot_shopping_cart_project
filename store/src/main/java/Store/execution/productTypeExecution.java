package Store.execution;

import Store.entity.ProductType;
import Store.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class productTypeExecution {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction tx= null;

        ProductType productType1 = new ProductType();
        productType1.setProductType("grocery");
        productType1.setRateOfProduct(30.00);

        ProductType productType2 = new ProductType();
        productType2.setProductType("cosmatic");
        productType2.setRateOfProduct(50.00);

        ProductType productType3 = new ProductType();
        productType3.setProductType("dairy product");
        productType3.setRateOfProduct(35.00);
        try {
            tx= session.beginTransaction();
            session.persist(productType1);
            session.persist(productType2);
            session.persist(productType3);
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
