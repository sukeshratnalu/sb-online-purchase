package com.sb.service;

import com.sb.dao.CustomerDAO;
import com.sb.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerDAO customerDAO;

  @Override
  public void addCustomer(Customer customer) {
    customerDAO.addCustomer(customer);
  }

  @Override
  public List<Customer> getAllCustomers() {
    return customerDAO.getAllCustomers();
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
