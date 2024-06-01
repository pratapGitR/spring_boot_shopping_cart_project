package org.shopping.controller;


import org.shopping.model.VendorModel;
import org.shopping.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping("/register")
    public String vendorRegister(){
        return "vendorForm";
    }

    @PostMapping("/saveVendor")
    public String saveVendor(@ModelAttribute VendorModel vendorModel){
        vendorService.saveVendorData(vendorModel);
        return "vendorSaved";
    }
}
