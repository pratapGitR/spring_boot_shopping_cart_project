package org.shopping.service;

import org.shopping.dao.ItemDAO;
import org.shopping.entity.Item;
import org.shopping.entity.ItemType;
import org.shopping.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemDAO itemDAO;

    //get item details from client and send it to db

    public String saveItemData(ItemModel itemModel){
        ItemType itemType= new ItemType();
        itemType.setItemTypeName(itemModel.getItemType());
        Item item = new Item();
        item.setItemName(itemModel.getItemName());
        item.setItemPrice(itemModel.getItemPrice());
        item.setItemQuantity(itemModel.getItemQuantity());
        item.setItemType(itemType);
        this.itemDAO.saveItem(item);
        return "Data sent";
    }
    //return data from db to user
    public List<ItemModel> allItems() {
        List<Item> itemList = this.itemDAO.itemList();
        List<ItemModel> itemModelList = new ArrayList<>();
        for (Item item: itemList) {
            ItemModel itemModel = new ItemModel();
            itemModel.setItemName(item.getItemName());
            itemModel.setItemPrice(item.getItemPrice());
            itemModel.setItemQuantity(item.getItemQuantity());
            itemModel.setItemType(item.getItemType().getItemTypeName());
            itemModelList.add(itemModel);
        }
        return itemModelList;
    }
}
