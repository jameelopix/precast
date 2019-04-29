package com.vme.precast.accountdetails.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.accountdetails.api.AccountDetailsServiceRequest;
import com.vme.precast.accountdetails.api.AccountDetailsValidator;
import com.vme.precast.repository.AccountDetailsRepo;

import coliseum.service.ErrorDTO;

public class AccountDetailsValidatorImpl implements AccountDetailsValidator {
 @Autowired
 AccountDetailsRepo accountDetailsRepo;

 @Override
 public ErrorDTO checkAccountDetailsDuplicate(AccountDetailsServiceRequest accountDetailsServiceRequest) {
 return null;
 }
}