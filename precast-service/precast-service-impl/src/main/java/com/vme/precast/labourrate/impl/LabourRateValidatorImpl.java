package com.vme.precast.labourrate.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.labourrate.api.LabourRateServiceRequest;
import com.vme.precast.labourrate.api.LabourRateValidator;
import com.vme.precast.repository.LabourRateRepo;

import coliseum.service.ErrorDTO;

public class LabourRateValidatorImpl implements LabourRateValidator {
 @Autowired
 LabourRateRepo labourRateRepo;

 @Override
 public ErrorDTO checkLabourRateDuplicate(LabourRateServiceRequest labourRateServiceRequest) {
 return null;
 }
}