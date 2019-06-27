package com.vme.precast.steeldetails.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.steeldetails.api.SteelDetailsServiceRequest;
import com.vme.precast.steeldetails.api.SteelDetailsValidator;
import com.vme.precast.repository.SteelDetailsRepo;

import coliseum.service.ErrorDTO;

public class SteelDetailsValidatorImpl implements SteelDetailsValidator {
 @Autowired
 SteelDetailsRepo steelDetailsRepo;

 @Override
 public ErrorDTO checkSteelDetailsDuplicate(SteelDetailsServiceRequest steelDetailsServiceRequest) {
 return null;
 }
}