package com.sb.dao;

import com.sb.model.Item;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

    @Override
    public List<Item> filterItems(String name) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Item.class);
        criteria.add( Restrictions.like("name", "%"+name+"%").ignoreCase());
        return criteria.list();
    }

    @Override
    public List<Item> filterItemsByPrice(Integer minPrice, Integer maxPrice) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Item.class);
        criteria.add( Restrictions.between("price", minPrice, maxPrice));
        return criteria.list();
    }
}
