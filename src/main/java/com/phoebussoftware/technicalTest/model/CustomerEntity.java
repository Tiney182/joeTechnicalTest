package com.phoebussoftware.technicalTest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {
  @Id Long customerId;
  String foreName;
  String surName;
  
  // @JsonFormat(pattern = "dd/MM/yyyy") //Throwing error without format now in DTO 
  Date dataOfBirth;

  @OneToMany List<AccountEntity> accountEntities;
}
