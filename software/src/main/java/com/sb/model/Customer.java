package com.sb.model;



import org.hibernate.validator.constraints.Email;

//import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    public Customer(){}
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column
  @NotNull
  @Size(min = 3, max = 40)
  private String name;

  @Column
  @NotNull
  @Email
  private String email;

  @Column
  private String telephone;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id")
  private Address address;


  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private List<Order> orderList;

  public Integer getId() {
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

    public List<Order> getCustomerOrders() {
        return orderList;
    }

    public void setCustomerOrders(List<Order> orderList) {
        this.orderList = orderList;
    }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
}
