package org.shopping.service;

import org.shopping.dao.DAO;
import org.shopping.entity.Customer;
import org.shopping.entity.Item;
import org.shopping.entity.ItemType;
import org.shopping.model.CustomerModel;
import org.shopping.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service

public class CustomerService {

    @Autowired
     private DAO<Customer>customerDao;
    @Transactional
    public String saveCustomerData(CustomerModel customerModel){

        Customer customer = new Customer();
        customer.setCustomerName(customerModel.getCustomerName());
        customer.setCustomerEmail(customerModel.getCustomerEmail());
        customer.setCustomerMobile(customerModel.getCustomerMobile());
        customer.setCustomerAddress(customerModel.getCustomerAddress());
        customer.setCustomerUserName(customerModel.getCustomerUserName());
        customer.setCustomerPassword(customerModel.getCustomerPassword());
        this.customerDao.save(customer);
        return "Data sent";
    }


    public List<CustomerModel>allCustomers(){
        List<Customer>customerList= this.customerDao.list();
        List<CustomerModel>customerModelList=new ArrayList<>();

        for(Customer cust : customerList ){
            CustomerModel customerModel = new CustomerModel();
            customerModel.setCustomerName(cust.getCustomerName());
            customerModel.setCustomerEmail(cust.getCustomerEmail());
            customerModel.setCustomerMobile(cust.getCustomerMobile());
            customerModel.setCustomerAddress(cust.getCustomerAddress());
            customerModel.setCustomerUserName(cust.getCustomerUserName());
            customerModel.setCustomerPassword(cust.getCustomerPassword());
            customerModelList.add(customerModel);
        }
        return customerModelList;
    }

    public CustomerModel getCustomerById(Integer customerId){
        Customer customer = this.customerDao.getById(customerId);
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomerName(customer.getCustomerName());
        customerModel.setCustomerEmail(customer.getCustomerEmail());
        customerModel.setCustomerMobile(customer.getCustomerMobile());
        customerModel.setCustomerAddress(customer.getCustomerAddress());
        customerModel.setCustomerUserName(customer.getCustomerUserName());
        customerModel.setCustomerPassword(customer.getCustomerPassword());

        return  customerModel;
    }
//    public void validateCustomerInfo(CustomerModel customerModel){
//        if()
//    }
    private boolean haveEmptyField(CustomerModel customerModel){
        return  customerModel.getCustomerName()==null || customerModel.getCustomerEmail()==null || customerModel.getCustomerAddress() ==null
                || customerModel.getCustomerMobile()==null || customerModel.getCustomerUserName()==null || customerModel.getCustomerPassword()==null ;
    }
    private boolean isValidEmail(String customerEmail){
        return customerEmail.contains("a");
    }
    private boolean isValidMobile(Long customerMobile){
        return customerMobile.toString().length()==10;
    }
    private boolean isValidPassword(String customerPassword){
        return  customerPassword.length()>=6;
    }

//    public List<Customer>getAllCustomers(){
//
//    }
}
