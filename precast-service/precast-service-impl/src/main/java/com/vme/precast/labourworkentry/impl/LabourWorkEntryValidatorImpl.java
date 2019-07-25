package com.vme.precast.labourworkentry.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.labourworkentry.api.LabourWorkEntryServiceRequest;
import com.vme.precast.labourworkentry.api.LabourWorkEntryValidator;
import com.vme.precast.repository.LabourWorkEntryRepo;

import coliseum.service.ErrorDTO;

public class LabourWorkEntryValidatorImpl implements LabourWorkEntryValidator {
 @Autowired
 LabourWorkEntryRepo labourWorkEntryRepo;

 @Override
 public ErrorDTO checkLabourWorkEntryDuplicate(LabourWorkEntryServiceRequest labourWorkEntryServiceRequest) {
 return null;
 }
}