package com.vme.precast.mixture.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.mixture.api.MixtureServiceRequest;
import com.vme.precast.mixture.api.MixtureValidator;
import com.vme.precast.repository.MixtureRepo;

import coliseum.service.ErrorDTO;

public class MixtureValidatorImpl implements MixtureValidator {
 @Autowired
 MixtureRepo mixtureRepo;

 @Override
 public ErrorDTO checkMixtureDuplicate(MixtureServiceRequest mixtureServiceRequest) {
 return null;
 }
}