package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employee")
@NamedQuery(name = "Employye.getEmployyesByDomainName", query = "select d from employee  d where d.domain=?1")
public class Employee {
    @javax.persistence.Id
    @GeneratedValue
    private int id;

    @Column(unique = true, name = "Empname")
    private String name;

    private int age;

    private double salary;
    @NotNull

    private String domain;

}
