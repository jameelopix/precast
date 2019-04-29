package com.vme.precast.accountdetails.api;

import coliseum.service.BaseServiceRequest;

public class AccountDetailsServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private AccountDetailsDTO accountDetailsDTO;

 private AccountDetailsSearchDTO accountDetailsSearchDTO;

 public AccountDetailsDTO getAccountDetailsDTO() {
 return accountDetailsDTO;
 }

 public void setAccountDetailsDTO(AccountDetailsDTO accountDetailsDTO) {
 this.accountDetailsDTO = accountDetailsDTO;
 }

 public AccountDetailsSearchDTO getAccountDetailsSearchDTO() {
 return accountDetailsSearchDTO;
 }

 public void setAccountDetailsSearchDTO(AccountDetailsSearchDTO accountDetailsSearchDTO) {
 this.accountDetailsSearchDTO = accountDetailsSearchDTO;
 }
}
