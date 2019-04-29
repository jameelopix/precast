package com.vme.precast.accountdetails.controller;

import java.util.List;

import com.vme.precast.accountdetails.api.AccountDetailsDTO;
import com.vme.precast.accountdetails.api.AccountDetailsSearchDTO;

import coliseum.web.BaseClientModel;

public class AccountDetailsClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private AccountDetailsDTO accountDetailsDTO;

 private AccountDetailsSearchDTO accountDetailsSearchDTO;

 private List<AccountDetailsDTO> accountDetailsDTOList;

 public AccountDetailsDTO getAccountDetailsDTO() {
 return accountDetailsDTO;
 }

 public void setAccountDetailsDTO(AccountDetailsDTO accountDetailsDTO) {
 this.accountDetailsDTO = accountDetailsDTO;
 }

 public List<AccountDetailsDTO> getAccountDetailsDTOList() {
 return accountDetailsDTOList;
 }

 public void setAccountDetailsDTOList(List<AccountDetailsDTO> accountDetailsDTOList) {
 this.accountDetailsDTOList = accountDetailsDTOList;
 }

 public AccountDetailsSearchDTO getAccountDetailsSearchDTO() {
 return accountDetailsSearchDTO;
 }

 public void setAccountDetailsSearchDTO(AccountDetailsSearchDTO accountDetailsSearchDTO) {
 this.accountDetailsSearchDTO = accountDetailsSearchDTO;
 }

}