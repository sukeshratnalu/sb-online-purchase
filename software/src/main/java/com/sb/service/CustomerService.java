package com.sb.service;

import com.sb.model.Customer;

import java.util.List;

public interface CustomerService {
  public void addCustomer(Customer customer);

  public List<Customer> getAllCustomers();

  public void deleteCustomer(Integer customerId);

  public Customer updateCustomer(Customer customer);

  public Customer getCustomer(Integer customerId);
}
