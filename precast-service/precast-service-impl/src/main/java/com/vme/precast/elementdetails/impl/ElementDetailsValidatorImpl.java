package com.vme.precast.elementdetails.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.elementdetails.api.ElementDetailsServiceRequest;
import com.vme.precast.elementdetails.api.ElementDetailsValidator;
import com.vme.precast.repository.ElementDetailsRepo;

import coliseum.service.ErrorDTO;

public class ElementDetailsValidatorImpl implements ElementDetailsValidator {
 @Autowired
 ElementDetailsRepo elementDetailsRepo;

 @Override
 public ErrorDTO checkElementDetailsDuplicate(ElementDetailsServiceRequest elementDetailsServiceRequest) {
 return null;
 }
}