package com.sb.service;

import com.sb.dao.ItemDAO;
import com.sb.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

  @Autowired
  private ItemDAO itemDAO;
  @Override
  public void addItems(Item item) {
    itemDAO.addItems(item);
  }

  @Override
  public List<Item> getAllItems() {
    return itemDAO.getAllItems();
  }

  @Override
  public void deleteItem(Integer itemId) {

  }

  @Override
  public Item updateItem(Item item) {
    return null;
  }

  @Override
  public Item getItem(Integer itemId) {
    return itemDAO.getItem(itemId);
  }

  @Override
  public List<Item> filterItemsByPrice(Integer minPrice, Integer maxPrice) {
    return itemDAO.filterItemsByPrice(minPrice, maxPrice);
  }

  @Override
  public List<Item> filterItems(String name) {
    return itemDAO.filterItems(name);
  }
}
