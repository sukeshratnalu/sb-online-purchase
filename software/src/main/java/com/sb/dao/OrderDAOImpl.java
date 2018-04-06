package com.sb.dao;

import com.sb.model.Item;
import com.sb.model.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addOrders(Order order) {
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return null;
    }

    @Override
    public void deleteOrder(Integer orderId) {
        Order order = (Order) sessionFactory.getCurrentSession().load(
                Order.class, orderId);
        if (null != order) {
            this.sessionFactory.getCurrentSession().delete(order);
        }
    }

    @Override
    public Order updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
        return order;
    }

    @Override
    public Order getOrder(Integer orderId) {
        return (Order) sessionFactory.getCurrentSession().get(
                Order.class, orderId);
    }

    @Override
    public void deleteOrderedItem(Integer orderId, Integer itemId) {
        Order order = (Order) sessionFactory.getCurrentSession().load(
                Order.class, orderId);
        Item item = (Item) sessionFactory.getCurrentSession().load(Item.class, itemId);
        Set<Item> items = order.getItems();
        if(items.size()>1){
            items.remove(item);
            sessionFactory.getCurrentSession().save(order);
            int priceCount = order.getPrice()-item.getPrice();
            order.setPrice(priceCount);
            this.updateOrder(order);
        }


    }
}
