package com.sb.controller;

import com.sb.model.Customer;
import com.sb.model.Item;
import com.sb.model.Order;
import com.sb.service.CustomerService;
import com.sb.service.ItemService;
import com.sb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.*;

@Controller
public class OrderController {

  @Autowired
  private OrderService orderService;

  @Autowired
  private CustomerService customerService;

  @Autowired
  private ItemService itemService;

  @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
  public ModelAndView saveOrder(HttpServletRequest request) {
    int customerId = Integer.parseInt(request.getParameter("customerId"));
    Customer customer = customerService.getCustomer(customerId);
    String itemIds [] = request.getParameterValues("item") ;
    // create instance of Random class
    Random rand = new Random();
    int rand_int1 = rand.nextInt(1000);
    String orderName = customer.getName() +'-' + rand_int1;
    Set items = new HashSet();
    int price = 0;
    for(int i =0;i<itemIds.length;i++){
      Item item = itemService.getItem(Integer.parseInt(itemIds[i]));
      price = price + item.getPrice();
      items.add(item);
    }
    Order order = new Order();
    order.setName(orderName);
    order.setPrice(price);
    order.setCustomer(customer);
    order.setItems(items);
    orderService.addOrders(order);
    return new ModelAndView("redirect:/customerOrder?id="+customerId);
  }

  @RequestMapping(value = "/orderItems", method = RequestMethod.GET)
  public ModelAndView orderItems(HttpServletRequest request) {
    int orderId = Integer.parseInt(request.getParameter("id"));
    ModelAndView model = new ModelAndView("orderItems");
    Order order = orderService.getOrder(orderId);
    List<Item> listItem = new ArrayList<>(order.getItems());
    model.addObject("orderItems", listItem);
    return model;
  }

  @RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
  public ModelAndView deleteItem(HttpServletRequest request) {
    int orderId = Integer.parseInt(request.getParameter("id"));
    orderService.deleteOrder(orderId);
    return new ModelAndView("redirect:/");
  }

}
