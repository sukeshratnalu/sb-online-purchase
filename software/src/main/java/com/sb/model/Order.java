package com.sb.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer_order")
public class Order implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column
  @NotNull
  @Size(min = 3, max = 10)
  private String name;

  @Column
  @NotNull
  private Integer price;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

    @ManyToMany(targetEntity = com.sb.model.Item.class, cascade = { CascadeType.ALL })
    @JoinTable(
            name="item_order",
            joinColumns={@JoinColumn(name="order_id")},
            inverseJoinColumns={@JoinColumn(name="item_id")}
    )
  private Set<Item> items;


  public int getId() {
    return id;
  }

  public void setId(Integer id) {
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

  public void setPrice(Integer price) {
    this.price = price;
  }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
