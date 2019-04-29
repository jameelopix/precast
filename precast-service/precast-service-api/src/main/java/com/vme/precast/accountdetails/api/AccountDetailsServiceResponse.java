package com.vme.precast.accountdetails.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class AccountDetailsServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<AccountDetailsDTO> accountDetailsDTOList;

 public List<AccountDetailsDTO> getAccountDetailsDTOList() {
 return accountDetailsDTOList;
 }

 public void setAccountDetailsDTOList(List<AccountDetailsDTO> accountDetailsDTOList) {
 this.accountDetailsDTOList = accountDetailsDTOList;
 }
}