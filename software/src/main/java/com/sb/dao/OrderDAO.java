package com.sb.dao;

import com.sb.model.Order;

import java.util.List;

public interface OrderDAO {
    public void addOrders(Order order);

    public List<Order> getAllOrder();

    public void deleteOrder(Integer orderId);

    public Order updateOrder(Order order);

    public Order getOrder(Integer orderId);
}
