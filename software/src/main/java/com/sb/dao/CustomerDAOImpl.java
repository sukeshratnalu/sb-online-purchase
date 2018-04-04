package com.sb.dao;

import com.sb.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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
  public void deleteCustomer(Integer customerId) {
      Customer customer = (Customer) sessionFactory.getCurrentSession().load(
              Customer.class, customerId);
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

    @Override
    public List<Customer> filterCustomers() {
        return null;
    }

}
