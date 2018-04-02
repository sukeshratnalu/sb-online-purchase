package com.sb.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column
  @NotNull
  private String street;

  @Column
  @NotNull
  private String city;

  @Column
  @NotNull
  private String state;

  @Column
  @NotNull
  private String pin;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }
}
