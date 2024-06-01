package org.shopping.validation;

import org.shopping.model.CustomerModel;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtil {
    private boolean haveEmptyField(CustomerModel customerModel){
        return  customerModel.getCustomerName()==null || customerModel.getCustomerEmail()==null || customerModel.getCustomerAddress() ==null
                || customerModel.getCustomerMobile()==null || customerModel.getCustomerUserName()==null || customerModel.getCustomerPassword()==null ;
    }
    private boolean isValidEmail(String customerEmail){
        return customerEmail.contains("@");
    }
    private boolean isValidMobile(Long customerMobile){
        return customerMobile.toString().length()==10;
    }
    private boolean isValidPassword(String customerPassword){
        return  customerPassword.length()>=6;
    }
}
