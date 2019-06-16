package com.vme.precast.partymaster.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.partymaster.api.PartyMasterServiceRequest;
import com.vme.precast.partymaster.api.PartyMasterValidator;
import com.vme.precast.repository.PartyMasterRepo;

import coliseum.service.ErrorDTO;

public class PartyMasterValidatorImpl implements PartyMasterValidator {
 @Autowired
 PartyMasterRepo partyMasterRepo;

 @Override
 public ErrorDTO checkPartyMasterDuplicate(PartyMasterServiceRequest partyMasterServiceRequest) {
 return null;
 }
}