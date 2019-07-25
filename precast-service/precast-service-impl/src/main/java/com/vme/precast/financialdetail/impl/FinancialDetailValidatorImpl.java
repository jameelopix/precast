package com.vme.precast.financialdetail.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.financialdetail.api.FinancialDetailServiceRequest;
import com.vme.precast.financialdetail.api.FinancialDetailValidator;
import com.vme.precast.repository.FinancialDetailRepo;

import coliseum.service.ErrorDTO;

public class FinancialDetailValidatorImpl implements FinancialDetailValidator {
 @Autowired
 FinancialDetailRepo financialDetailRepo;

 @Override
 public ErrorDTO checkFinancialDetailDuplicate(FinancialDetailServiceRequest financialDetailServiceRequest) {
 return null;
 }
}