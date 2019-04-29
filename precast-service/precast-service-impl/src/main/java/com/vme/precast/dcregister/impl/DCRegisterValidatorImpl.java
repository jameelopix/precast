package com.vme.precast.dcregister.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.dcregister.api.DCRegisterServiceRequest;
import com.vme.precast.dcregister.api.DCRegisterValidator;
import com.vme.precast.repository.DCRegisterRepo;

import coliseum.service.ErrorDTO;

public class DCRegisterValidatorImpl implements DCRegisterValidator {
 @Autowired
 DCRegisterRepo dCRegisterRepo;

 @Override
 public ErrorDTO checkDCRegisterDuplicate(DCRegisterServiceRequest dCRegisterServiceRequest) {
 return null;
 }
}