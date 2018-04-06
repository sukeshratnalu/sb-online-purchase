package com.sb.dao;

import com.sb.model.Customer;
import com.sb.model.Item;
import com.sb.model.Order;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Set;

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
  public void deleteCustomer(Integer customerId) {
      Customer customer = (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);
      if (null != customer) {
          this.sessionFactory.getCurrentSession().delete(customer);
      }
  }

  @Override
  public Customer updateCustomer(Customer customer) {
      sessionFactory.getCurrentSession().update(customer);
      return customer;
  }

  @Override
  public Customer getCustomer(Integer customerId) {
      return (Customer) sessionFactory.getCurrentSession().get(
              Customer.class, customerId);
  }

}
