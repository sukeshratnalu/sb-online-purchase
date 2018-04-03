package com.sb.controller;


import com.sb.model.Customer;
import com.sb.service.CustomerService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class CustomerController {
  private static final Logger logger = Logger
          .getLogger(CustomerController.class);


  public CustomerController() {
    System.out.println("CustomerController()");
  }


  @Autowired
  private CustomerService customerService;

  @RequestMapping(value = "/")
  public ModelAndView listCustomer() throws IOException {
    ModelAndView model = new ModelAndView("home");
    List<Customer> listCustomer = customerService.getAllCustomers();
    System.out.println("Customer Data");
    System.out.println(listCustomer);
    model.addObject("listCustomer", listCustomer);
    System.out.println(model);
    return model;
  }

  @RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
  public ModelAndView newContact(ModelAndView model) {
    Customer customer = new Customer();
    model.addObject("customer", customer);
    model.setViewName("customer");
    return model;
  }


  @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
  public ModelAndView saveCustomer(@ModelAttribute Customer customer) {
    customerService.addCustomer(customer);
    return new ModelAndView("redirect:/");
  }



}
