package org.shopping.model;

import lombok.Data;
import org.shopping.entity.ItemType;

@Data
public class ItemModel {
    private String itemName;
    private  Integer itemQuantity;
    private Double itemPrice;
    private ItemType itemType;
}
