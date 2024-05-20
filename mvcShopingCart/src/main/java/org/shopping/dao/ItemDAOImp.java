package org.shopping.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.shopping.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemDAOImp implements ItemDAO {
    private SessionFactory sessionFactory;
    public ItemDAOImp(SessionFactory  sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public String saveItem(Item item) {
        Session session= this.sessionFactory.openSession();
        try{
            session.save(item);
            System.out.println("Item request sent to Mart"+item);

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Error Occurred while saving data"+e.getMessage());
        }finally {
            if(session!= null){
                session.close();
            }
        }

        return "Successfully Added Data to DB";
    }

    @Override
    public List<Item> itemList() {
        List<Item> allItems = new ArrayList<>();
        String selectQuery ="from Item";
        Session session = this.sessionFactory.openSession();
        try {
            Query query= session.createQuery(selectQuery);
            allItems= query.list();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Error Occurred while getting data"+e.getMessage());
        }finally {
            if(session!= null){
                session.close();
            }
        }

        return allItems;
    }
}
