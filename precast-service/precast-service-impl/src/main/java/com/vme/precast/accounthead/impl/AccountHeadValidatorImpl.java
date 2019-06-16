package com.vme.precast.accounthead.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.accounthead.api.AccountHeadServiceRequest;
import com.vme.precast.accounthead.api.AccountHeadValidator;
import com.vme.precast.repository.AccountHeadRepo;

import coliseum.service.ErrorDTO;

public class AccountHeadValidatorImpl implements AccountHeadValidator {
 @Autowired
 AccountHeadRepo accountHeadRepo;

 @Override
 public ErrorDTO checkAccountHeadDuplicate(AccountHeadServiceRequest accountHeadServiceRequest) {
 return null;
 }
}