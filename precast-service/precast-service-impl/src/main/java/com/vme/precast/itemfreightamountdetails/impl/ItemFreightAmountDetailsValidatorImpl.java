package com.vme.precast.itemfreightamountdetails.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsServiceRequest;
import com.vme.precast.itemfreightamountdetails.api.ItemFreightAmountDetailsValidator;
import com.vme.precast.repository.ItemFreightAmountDetailsRepo;

import coliseum.service.ErrorDTO;

public class ItemFreightAmountDetailsValidatorImpl implements ItemFreightAmountDetailsValidator {
 @Autowired
 ItemFreightAmountDetailsRepo itemFreightAmountDetailsRepo;

 @Override
 public ErrorDTO checkItemFreightAmountDetailsDuplicate(ItemFreightAmountDetailsServiceRequest itemFreightAmountDetailsServiceRequest) {
 return null;
 }
}