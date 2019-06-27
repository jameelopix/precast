package com.vme.precast.rawmaterial.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.rawmaterial.api.RawMaterialServiceRequest;
import com.vme.precast.rawmaterial.api.RawMaterialValidator;
import com.vme.precast.repository.RawMaterialRepo;

import coliseum.service.ErrorDTO;

public class RawMaterialValidatorImpl implements RawMaterialValidator {
 @Autowired
 RawMaterialRepo rawMaterialRepo;

 @Override
 public ErrorDTO checkRawMaterialDuplicate(RawMaterialServiceRequest rawMaterialServiceRequest) {
 return null;
 }
}