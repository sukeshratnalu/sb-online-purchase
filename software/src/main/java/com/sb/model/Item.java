package com.sb.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column
  @NotNull
  @Size(min = 3, max = 10)
  private String name;

  @Column
  @NotNull
  private int price;

  /*private List<Order> orderList;
  @ManyToMany(
    cascade = {CascadeType.PERSIST, CascadeType.MERGE},
    mappedBy = "items",
    targetEntity = Order.class
  )*/


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  /*public List<Order> getOrderList() {
    return orderList;
  }

  public void setOrderList(List<Order> orderList) {
    this.orderList = orderList;
  }*/
}
