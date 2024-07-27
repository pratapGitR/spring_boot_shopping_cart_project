package org.example.spring_boot_shopping_cart_project.service;


import org.example.spring_boot_shopping_cart_project.entity.Item;
import org.example.spring_boot_shopping_cart_project.entity.ItemType;
import org.example.spring_boot_shopping_cart_project.model.ItemModel;
import org.example.spring_boot_shopping_cart_project.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    public String saveItem(ItemModel itemModel){

        ItemType itemType= new ItemType();
        itemType.setItemTypeName(itemModel.getItemType());
        Item item = new Item();
        item.setItemName(itemModel.getItemName());
        item.setItemPrice(itemModel.getItemPrice());
        item.setItemQuantity(itemModel.getItemQuantity());
        item.setItemType(itemType);

        itemRepo.save(item);
        return "Data saved";
    }

    public List<ItemModel> itemList() {
        List<Item> itemList = this.itemRepo.findAll();
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
