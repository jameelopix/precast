package com.vme.precast.accounthead.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class AccountHeadServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<AccountHeadDTO> accountHeadDTOList;

 public List<AccountHeadDTO> getAccountHeadDTOList() {
 return accountHeadDTOList;
 }

 public void setAccountHeadDTOList(List<AccountHeadDTO> accountHeadDTOList) {
 this.accountHeadDTOList = accountHeadDTOList;
 }
}