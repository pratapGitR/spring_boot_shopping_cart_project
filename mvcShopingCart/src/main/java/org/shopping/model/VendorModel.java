package org.shopping.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class VendorModel {

    private String vendorName;
    private String vendorEmail;
    private Long vendorMobile;
    private String vendorAddress;
    private String vendorUserName;
    private String vendorPassword;
    private String vendorRegistration;
}
