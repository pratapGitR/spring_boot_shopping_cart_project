package springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import springmvc.entity.User;

public class UserDaoImp implements UserDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);

    }
}
