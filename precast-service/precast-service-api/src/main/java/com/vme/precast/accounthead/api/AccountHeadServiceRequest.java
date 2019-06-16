package com.vme.precast.accounthead.api;

import coliseum.service.BaseServiceRequest;

public class AccountHeadServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private AccountHeadDTO accountHeadDTO;

 private AccountHeadSearchDTO accountHeadSearchDTO;

 public AccountHeadDTO getAccountHeadDTO() {
 return accountHeadDTO;
 }

 public void setAccountHeadDTO(AccountHeadDTO accountHeadDTO) {
 this.accountHeadDTO = accountHeadDTO;
 }

 public AccountHeadSearchDTO getAccountHeadSearchDTO() {
 return accountHeadSearchDTO;
 }

 public void setAccountHeadSearchDTO(AccountHeadSearchDTO accountHeadSearchDTO) {
 this.accountHeadSearchDTO = accountHeadSearchDTO;
 }
}
