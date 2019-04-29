package com.vme.precast.company.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.company.api.CompanyServiceRequest;
import com.vme.precast.company.api.CompanyValidator;
import com.vme.precast.repository.CompanyRepo;

import coliseum.service.ErrorDTO;

public class CompanyValidatorImpl implements CompanyValidator {
 @Autowired
 CompanyRepo companyRepo;

 @Override
 public ErrorDTO checkCompanyDuplicate(CompanyServiceRequest companyServiceRequest) {
 return null;
 }
}