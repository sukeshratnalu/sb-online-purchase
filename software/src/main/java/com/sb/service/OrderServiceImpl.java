package com.sb.service;

import com.sb.dao.OrderDAO;
import com.sb.model.Order;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderDAO orderDAO;

  @Override
  public void addOrders(Order order) {
    orderDAO.addOrders(order);
  }

  @Override
  public List<Order> getAllOrder() {
    return null;
  }

  @Override
  public void deleteOrder(Integer orderId) {
    orderDAO.deleteOrder(orderId);
  }

  @Override
  public Order updateOrder(Order order) {
    return null;
  }

  @Override
  public Order getOrder(Integer orderId) {
    Order order = orderDAO.getOrder(orderId);
    Hibernate.initialize(order.getItems());
    return order;
  }

  @Override
  public void deleteOrderedItem(Integer orderId, Integer itemId) {
    orderDAO.deleteOrderedItem(orderId, itemId);
  }
}
