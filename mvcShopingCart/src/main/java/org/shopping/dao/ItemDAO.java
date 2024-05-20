package org.shopping.dao;

import org.shopping.entity.Item;

import java.util.List;

public interface ItemDAO {
    String saveItem(Item item);
    List<Item>itemList();
}
