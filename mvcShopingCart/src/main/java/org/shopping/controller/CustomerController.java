package org.shopping.controller;

import org.shopping.model.CustomerModel;

import org.shopping.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String home(){
        return "landingCustomer";
    }

    @GetMapping("/form")
    public String form(){
        return "customerForm";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute CustomerModel customerModel, Model model){
        customerService.saveCustomerData(customerModel);
        model.addAttribute("customer",customerModel);
        return "showCustomer";
    }
    @GetMapping("getCustomerById")
    public String getCustomerById(@RequestParam("customerId")Integer customerId, Model model){
//        if(customerId == null){
//            return "error";
//        }else{
            CustomerModel customerModel = this.customerService.getCustomerById(customerId);
            model.addAttribute("customerInfo", customerModel);
            return "showCustomer";
//        }

    }

    @GetMapping("/getAllCustomer")
    public String getAllCustomer(Model model){
        List<CustomerModel>customerModelList = this.customerService.allCustomers();
        model.addAttribute("customers", customerModelList);
        return "allCustomers";
    }

}
