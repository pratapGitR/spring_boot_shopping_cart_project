package hibernate;

import annotatedEntity.BusInfo;
import annotatedEntity.Person;
import annotatedEntity.TicketInfo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {
    public static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(BusInfo.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(TicketInfo.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return  sessionFactory;
    }
}
