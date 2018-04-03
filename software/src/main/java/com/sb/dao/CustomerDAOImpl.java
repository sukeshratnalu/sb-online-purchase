package com.sb.dao;

import com.sb.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void addCustomer(Customer customer) {
    sessionFactory.getCurrentSession().saveOrUpdate(customer);
  }

  @Override
  public List<Customer> getAllCustomers() {
    return sessionFactory.getCurrentSession().createQuery("from Customer")
            .list();
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
