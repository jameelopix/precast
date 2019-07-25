package com.vme.precast.subcontractor.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.subcontractor.api.SubContractorServiceRequest;
import com.vme.precast.subcontractor.api.SubContractorValidator;
import com.vme.precast.repository.SubContractorRepo;

import coliseum.service.ErrorDTO;

public class SubContractorValidatorImpl implements SubContractorValidator {
 @Autowired
 SubContractorRepo subContractorRepo;

 @Override
 public ErrorDTO checkSubContractorDuplicate(SubContractorServiceRequest subContractorServiceRequest) {
 return null;
 }
}