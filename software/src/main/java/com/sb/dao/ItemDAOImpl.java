package com.sb.dao;

import com.sb.model.Customer;
import com.sb.model.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDAOImpl implements ItemDAO{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addItems(Item item) {
        sessionFactory.getCurrentSession().saveOrUpdate(item);
    }

    @Override
    public List<Item> getAllItems() {
        return sessionFactory.getCurrentSession().createQuery("from Item")
                .list();
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
        return (Item) sessionFactory.getCurrentSession().get(
                Item.class, itemId);
    }
}
