package com.sb.dao;

import com.sb.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void addCustomer(Customer customer) {
    sessionFactory.getCurrentSession().saveOrUpdate(customer);
  }

  @Override
  public List<Customer> getAllCustomers() {
    return null;
  }

  @Override
  public void deleteCustomer(int customerId) {

  }

  @Override
  public Customer updateCustomer(Customer customer) {
    return null;
  }

  @Override
  public Customer getCustomer(int customerId) {
    return null;
  }
}
