package com.phoebussoftware.technicalTest.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
  Long customerId;

  @NotNull
  String foreName;

  @NotNull
  String surName;

  @NotNull
  @JsonFormat(pattern = "dd/MM/yyyy") //Throwing error without format 
  Date dataOfBirth;
  List<AccountDTO> accountDTOS;
}
