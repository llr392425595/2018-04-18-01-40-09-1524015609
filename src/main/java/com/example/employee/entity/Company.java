package com.example.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {

  @Id
  @GeneratedValue
  private Integer id;
  private String companyName;
  private Integer employeesNumber;

  public Company() { }

  public Company(Integer id, String companyName, Integer employeesNumber) {
    this.id = id;
    this.companyName = companyName;
    this.employeesNumber = employeesNumber;
  }

  public Company(String companyName, Integer employeesNumber) {
    this.companyName = companyName;
    this.employeesNumber = employeesNumber;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public Integer getEmployeesNumber() {
    return employeesNumber;
  }

  public void setEmployeesNumber(Integer employeesNumber) {
    this.employeesNumber = employeesNumber;
  }
}
