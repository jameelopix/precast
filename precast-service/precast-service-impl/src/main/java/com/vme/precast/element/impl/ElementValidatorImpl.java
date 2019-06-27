package com.vme.precast.element.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.element.api.ElementServiceRequest;
import com.vme.precast.element.api.ElementValidator;
import com.vme.precast.repository.ElementRepo;

import coliseum.service.ErrorDTO;

public class ElementValidatorImpl implements ElementValidator {
 @Autowired
 ElementRepo elementRepo;

 @Override
 public ErrorDTO checkElementDuplicate(ElementServiceRequest elementServiceRequest) {
 return null;
 }
}