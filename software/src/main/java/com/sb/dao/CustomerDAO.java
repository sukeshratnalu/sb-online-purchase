package com.sb.dao;

import com.sb.model.Customer;

import java.util.List;

public interface CustomerDAO {
  public void addCustomer(Customer customer);

  public List<Customer> getAllCustomers();

  public void deleteCustomer(int customerId);

  public Customer updateCustomer(Customer customer);

  public Customer getCustomer(int customerId);

}
