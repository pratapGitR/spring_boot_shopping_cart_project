package org.shopping.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.shopping.entity.Vendor;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class VendorDAOImp implements  DAO<Vendor>{
    public VendorDAOImp() {
    }
    private SessionFactory sessionFactory;

    public VendorDAOImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    private List<Vendor>vendorList = new ArrayList<>();

    public VendorDAOImp(LocalSessionFactoryBean sessionFactory) {
    }


    @Override
    public String save(Vendor vendor) {
        Session session= this.sessionFactory.openSession();
        try{
            session.save(vendor);
            System.out.println(vendor);

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Error Occurred while saving data"+e.getMessage());
        }finally {
            if(session!= null){
                session.close();
            }
        }
        return "saved vendor data";
    }

    @Override
    public List <Vendor>list() {
        String selectQuery ="from Vendor";
        Session session = this.sessionFactory.openSession();
        try {
            Query query= session.createQuery(selectQuery);
            vendorList= query.list();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Error Occurred while getting data"+e.getMessage());
        }finally {
            if(session!= null){
                session.close();
            }
        }
        return vendorList;
    }

    @Override
    public Vendor getById(Integer id) {
        return null;
    }
}
