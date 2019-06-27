package com.vme.precast.mixtureitem.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.mixtureitem.api.MixtureItemServiceRequest;
import com.vme.precast.mixtureitem.api.MixtureItemValidator;
import com.vme.precast.repository.MixtureItemRepo;

import coliseum.service.ErrorDTO;

public class MixtureItemValidatorImpl implements MixtureItemValidator {
 @Autowired
 MixtureItemRepo mixtureItemRepo;

 @Override
 public ErrorDTO checkMixtureItemDuplicate(MixtureItemServiceRequest mixtureItemServiceRequest) {
 return null;
 }
}