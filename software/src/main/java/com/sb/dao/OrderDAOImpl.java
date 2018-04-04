package com.sb.dao;

import com.sb.model.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
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
        return null;
    }

    @Override
    public Order getOrder(Integer orderId) {
        return (Order) sessionFactory.getCurrentSession().get(
                Order.class, orderId);
    }
}
