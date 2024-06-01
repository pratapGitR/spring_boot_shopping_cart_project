package org.shopping.service;

import org.shopping.dao.DAO;

import org.shopping.entity.Vendor;
import org.shopping.model.VendorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class VendorService {
    @Autowired
    private DAO<Vendor>vendorDAO;
    @Transactional
    public String saveVendorData(VendorModel vendorModel){
       Vendor vendor = new Vendor();
        vendor.setVendorName(vendorModel.getVendorName());
        vendor.setVendorEmail(vendorModel.getVendorEmail());
        vendor.setVendorMobile(vendorModel.getVendorMobile());
        vendor.setVendorAddress(vendorModel.getVendorAddress());
        vendor.setVendorUserName(vendorModel.getVendorUserName());
        vendor.setVendorPassword(vendorModel.getVendorPassword());
        this.vendorDAO.save(vendor);
        return "Data sent";
    }
}
