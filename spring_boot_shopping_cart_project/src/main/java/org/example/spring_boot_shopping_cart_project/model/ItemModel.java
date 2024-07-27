package org.example.spring_boot_shopping_cart_project.model;

import lombok.Data;



@Data
public class ItemModel {

    private String itemName;
    private  Integer itemQuantity;
    private Double itemPrice;
    private String itemType;
}
