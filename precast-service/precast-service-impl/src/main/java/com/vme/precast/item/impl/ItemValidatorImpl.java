package com.vme.precast.item.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.item.api.ItemServiceRequest;
import com.vme.precast.item.api.ItemValidator;
import com.vme.precast.repository.ItemRepo;

import coliseum.service.ErrorDTO;

public class ItemValidatorImpl implements ItemValidator {
 @Autowired
 ItemRepo itemRepo;

 @Override
 public ErrorDTO checkItemDuplicate(ItemServiceRequest itemServiceRequest) {
 return null;
 }
}