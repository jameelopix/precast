package com.vme.precast.dcitem.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.dcitem.api.DCItemServiceRequest;
import com.vme.precast.dcitem.api.DCItemValidator;
import com.vme.precast.repository.DCItemRepo;

import coliseum.service.ErrorDTO;

public class DCItemValidatorImpl implements DCItemValidator {
 @Autowired
 DCItemRepo dCItemRepo;

 @Override
 public ErrorDTO checkDCItemDuplicate(DCItemServiceRequest dCItemServiceRequest) {
 return null;
 }
}