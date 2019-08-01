package com.vme.precast.productionplan.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.productionplan.api.ProductionPlanServiceRequest;
import com.vme.precast.productionplan.api.ProductionPlanValidator;
import com.vme.precast.repository.ProductionPlanRepo;

import coliseum.service.ErrorDTO;

public class ProductionPlanValidatorImpl implements ProductionPlanValidator {
 @Autowired
 ProductionPlanRepo productionPlanRepo;

 @Override
 public ErrorDTO checkProductionPlanDuplicate(ProductionPlanServiceRequest productionPlanServiceRequest) {
 return null;
 }
}