package org.shopping.controller;

import org.shopping.model.ItemModel;
import org.shopping.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/")
    public String landing(){
        return"mart";
    }

    @PostMapping("/saveItem")
    public String saveItem(@ModelAttribute ItemModel itemModel){
        itemService.saveItemData(itemModel);

        return "saved";
    }

    @GetMapping("/allItems")
    public String allItems(Model model){
        List<ItemModel> itemModelList = this.itemService.allItems();
        model.addAttribute("allItems", itemModelList);

        return "displayAllItems";
    }
}
