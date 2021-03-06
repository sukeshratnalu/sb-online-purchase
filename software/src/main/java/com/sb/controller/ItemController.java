package com.sb.controller;

import com.sb.model.Customer;
import com.sb.model.Item;
import com.sb.service.CustomerService;
import com.sb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class ItemController {
  public ItemController(){
    System.out.println("getting Item controller");
  }
  @Autowired
  private ItemService itemService;
  @RequestMapping(value = "/itemList")
  public ModelAndView listCustomer(HttpServletRequest request) throws IOException {
    int customerId = Integer.parseInt(request.getParameter("id"));
    ModelAndView model = new ModelAndView("item");
    List<Item> listItem = itemService.getAllItems();
    model.addObject("listItem", listItem);
    model.addObject("customerId",customerId);
    return model;
  }

  @RequestMapping(value = "/newItem", method = RequestMethod.GET)
  public ModelAndView newContact(ModelAndView model) {
    Item item = new Item();
    model.addObject("item", item);
    model.setViewName("itemForm");
    return model;
  }

  @RequestMapping(value = "/saveItem", method = RequestMethod.POST)
  public ModelAndView saveItem(@ModelAttribute Item item) {
    if (item.getId() == null) {
      itemService.addItems(item);
    } else {
      itemService.updateItem(item);
    }
    return new ModelAndView("redirect:/");
  }

  @RequestMapping(value = "/filterItems")
  public ModelAndView filterItem(HttpServletRequest request) {
    ModelAndView model = new ModelAndView("item");
    String name = request.getParameter("name");
    List<Item> listItem = itemService.filterItems(name);
    model.addObject("listItem", listItem);
    return model;
  }
  @RequestMapping(value = "/filterItemsByPrice")
  public ModelAndView filterItemsByPrice(HttpServletRequest request) {
    ModelAndView model = new ModelAndView("item");
    int minPrice = Integer.parseInt(request.getParameter("minPrice"));
    int maxPrice = Integer.parseInt(request.getParameter("maxPrice"));
    List<Item> listItem = itemService.filterItemsByPrice(minPrice, maxPrice);
    model.addObject("listItem", listItem);
    return model;
  }
}
