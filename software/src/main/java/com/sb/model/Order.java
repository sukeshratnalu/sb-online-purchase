package com.sb.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {

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

  /*private List<Item> itemList;
  @ManyToMany(
    targetEntity=Item.class,
    cascade={CascadeType.PERSIST, CascadeType.MERGE}
  )
  @JoinTable(
    name="ITEMS_ORDER",
    joinColumns=@JoinColumn(name="ORDER_ID"),
    inverseJoinColumns=@JoinColumn(name="ITEM_ID")
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

  /*public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }*/
}
