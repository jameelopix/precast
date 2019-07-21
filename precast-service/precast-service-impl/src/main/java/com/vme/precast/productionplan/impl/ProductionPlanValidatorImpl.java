package com.vme.precast.productionplan.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.ProductionPlan;
import com.vme.precast.domain.PurchaseRegister;
import com.vme.precast.productionplan.api.ProductionPlanDTO;
import com.vme.precast.productionplan.api.ProductionPlanServiceRequest;
import com.vme.precast.productionplan.api.ProductionPlanValidator;
import com.vme.precast.purchaseregister.api.PurchaseRegisterDTO;
import com.vme.precast.repository.ProductionPlanRepo;

import coliseum.service.ErrorDTO;

public class ProductionPlanValidatorImpl implements ProductionPlanValidator {
    @Autowired
    ProductionPlanRepo productionPlanRepo;

    @Override
    public ErrorDTO checkProductionPlanDuplicate(ProductionPlanServiceRequest productionPlanServiceRequest) {
        ErrorDTO errorDTO = null;
//        ProductionPlanDTO productionPlanDTO = productionPlanServiceRequest.getProductionPlanDTO();
//        ProductionPlan purchaseRegister = productionPlanRepo.findById(productionPlanDTO.getId()).get();
//        if (true == purchaseRegister.getApproved()) {
//            errorDTO = new ErrorDTO("ERR_PR_102", "Operation not possible, Since it is approved.");
//        }
        return errorDTO;
    }
}