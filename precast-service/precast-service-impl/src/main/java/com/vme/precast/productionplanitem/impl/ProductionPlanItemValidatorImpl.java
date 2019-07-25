package com.vme.precast.productionplanitem.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.productionplanitem.api.ProductionPlanItemServiceRequest;
import com.vme.precast.productionplanitem.api.ProductionPlanItemValidator;
import com.vme.precast.repository.ProductionPlanItemRepo;

import coliseum.service.ErrorDTO;

public class ProductionPlanItemValidatorImpl implements ProductionPlanItemValidator {
 @Autowired
 ProductionPlanItemRepo productionPlanItemRepo;

 @Override
 public ErrorDTO checkProductionPlanItemDuplicate(ProductionPlanItemServiceRequest productionPlanItemServiceRequest) {
 return null;
 }
}