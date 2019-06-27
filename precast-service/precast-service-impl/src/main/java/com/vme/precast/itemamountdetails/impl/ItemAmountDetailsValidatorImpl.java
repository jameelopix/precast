package com.vme.precast.itemamountdetails.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.itemamountdetails.api.ItemAmountDetailsServiceRequest;
import com.vme.precast.itemamountdetails.api.ItemAmountDetailsValidator;
import com.vme.precast.repository.ItemAmountDetailsRepo;

import coliseum.service.ErrorDTO;

public class ItemAmountDetailsValidatorImpl implements ItemAmountDetailsValidator {
 @Autowired
 ItemAmountDetailsRepo itemAmountDetailsRepo;

 @Override
 public ErrorDTO checkItemAmountDetailsDuplicate(ItemAmountDetailsServiceRequest itemAmountDetailsServiceRequest) {
 return null;
 }
}