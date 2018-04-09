package com.sb.dao;

import com.sb.model.Customer;

import java.util.List;

public interface CustomerDAO {
  public void addCustomer(Customer customer);

  public List<Customer> getAllCustomers();

  public void deleteCustomer(Integer customerId);

  public Customer updateCustomer(Customer customer);

  public Customer getCustomer(Integer customerId);

  public List<Customer> filterCustomer(String name);
}
