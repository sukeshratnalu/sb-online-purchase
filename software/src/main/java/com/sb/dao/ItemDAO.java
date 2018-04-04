package com.sb.dao;


import com.sb.model.Item;

import java.util.List;

public interface ItemDAO {
    public void addItems(Item item);

    public List<Item> getAllItems();

    public void deleteItem(Integer itemId);

    public Item updateItem(Item item);

    public Item getItem(Integer itemId);
}
