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

    @GetMapping("/form")
    public String landing(){
        return "customerForm";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute CustomerModel customerModel, Model model){
        customerService.saveCustomerData(customerModel);
        model.addAttribute("customer",customerModel);
        return "showCustomer";
    }
    @GetMapping("/getCustomerById/{id}")
    public String getCustomerById(@PathVariable("id") String customerId, Model model){
        Integer convertedCustomerId = Integer.parseInt(customerId);
        CustomerModel customerModel = this.customerService.getCustomerById(convertedCustomerId);
        model.addAttribute("customerInfo", customerModel);
        return "displayCustomerById";
    }

    @GetMapping("/getAllCustomer")
    public String getAllCustomer(Model model){
        List<CustomerModel>customerModelList = this.customerService.allCustomers();
        model.addAttribute("customers", customerModelList);
        return "allCustomers";
    }

}
