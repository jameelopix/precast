package com.vme.precast.itembasicamountdetails.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsServiceRequest;
import com.vme.precast.itembasicamountdetails.api.ItemBasicAmountDetailsValidator;
import com.vme.precast.repository.ItemBasicAmountDetailsRepo;

import coliseum.service.ErrorDTO;

public class ItemBasicAmountDetailsValidatorImpl implements ItemBasicAmountDetailsValidator {
 @Autowired
 ItemBasicAmountDetailsRepo itemBasicAmountDetailsRepo;

 @Override
 public ErrorDTO checkItemBasicAmountDetailsDuplicate(ItemBasicAmountDetailsServiceRequest itemBasicAmountDetailsServiceRequest) {
 return null;
 }
}