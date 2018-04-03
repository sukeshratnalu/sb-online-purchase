package com.sb.service;

import com.sb.dao.CustomerDAO;
import com.sb.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
