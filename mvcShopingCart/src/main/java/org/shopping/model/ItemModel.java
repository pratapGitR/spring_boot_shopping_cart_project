package org.shopping.model;

import lombok.Data;


@Data
public class ItemModel {
    private String itemName;
    private  Integer itemQuantity;
    private Double itemPrice;
    private String itemType;
}
