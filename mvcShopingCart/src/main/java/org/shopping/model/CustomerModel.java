package org.shopping.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CustomerModel {

    private String customerName;
    private String customerEmail;
    private Long customerMobile;
    private String customerAddress;
    private String  customerUserName;
    private String customerPassword;
}
