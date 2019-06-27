package com.vme.precast.elementtype.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.elementtype.api.ElementTypeServiceRequest;
import com.vme.precast.elementtype.api.ElementTypeValidator;
import com.vme.precast.repository.ElementTypeRepo;

import coliseum.service.ErrorDTO;

public class ElementTypeValidatorImpl implements ElementTypeValidator {
 @Autowired
 ElementTypeRepo elementTypeRepo;

 @Override
 public ErrorDTO checkElementTypeDuplicate(ElementTypeServiceRequest elementTypeServiceRequest) {
 return null;
 }
}