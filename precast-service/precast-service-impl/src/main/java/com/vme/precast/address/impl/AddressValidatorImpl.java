package com.vme.precast.address.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.address.api.AddressServiceRequest;
import com.vme.precast.address.api.AddressValidator;
import com.vme.precast.repository.AddressRepo;

import coliseum.service.ErrorDTO;

public class AddressValidatorImpl implements AddressValidator {
 @Autowired
 AddressRepo addressRepo;

 @Override
 public ErrorDTO checkAddressDuplicate(AddressServiceRequest addressServiceRequest) {
 return null;
 }
}