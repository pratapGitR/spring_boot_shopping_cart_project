package org.shopping.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.shopping.entity.Customer;

import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerDAOImp implements DAO <Customer>{

    public CustomerDAOImp(SessionFactory  sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    private SessionFactory sessionFactory;
    private List<Customer>customerList = new ArrayList<>();

    @Override
    public String save(Customer customer) {
        Session session= this.sessionFactory.openSession();
        try{
            session.save(customer);
            System.out.println(customer);

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Error Occurred while saving data"+e.getMessage());
        }finally {
            if(session!= null){
                session.close();
            }
        }
        return "saved customer data";
    }


    @Override
    public List <Customer>list() {
        String selectQuery ="from Customer";
        Session session = this.sessionFactory.openSession();
        try {
            Query query= session.createQuery(selectQuery);
            customerList= query.list();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Error Occurred while getting data"+e.getMessage());
        }finally {
            if(session!= null){
                session.close();
            }
        }
        return customerList;
//        return sessionFactory.getCurrentSession().createQuery("from Customer", Customer.class).list();
    }




    @Override
    public Customer getById(Integer customerId)
    {
        Customer customer = new Customer();
        Session session = this.sessionFactory.openSession();
        try{
            customer = (Customer) session.load(Customer.class, customerId);
        }catch(Exception e) {
            System.err.println("Error Detail"+e.getMessage());
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        return customer;
    }
}
