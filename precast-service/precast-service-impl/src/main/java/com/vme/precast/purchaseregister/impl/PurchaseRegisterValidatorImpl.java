package com.vme.precast.purchaseregister.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.PurchaseRegister;
import com.vme.precast.purchaseregister.api.PurchaseRegisterDTO;
import com.vme.precast.purchaseregister.api.PurchaseRegisterServiceRequest;
import com.vme.precast.purchaseregister.api.PurchaseRegisterValidator;
import com.vme.precast.repository.PurchaseRegisterRepo;

import coliseum.service.ErrorDTO;

public class PurchaseRegisterValidatorImpl implements PurchaseRegisterValidator {
    @Autowired
    PurchaseRegisterRepo purchaseRegisterRepo;

    @Override
    public ErrorDTO checkPurchaseRegisterDuplicate(PurchaseRegisterServiceRequest purchaseRegisterServiceRequest) {
        return null;
    }

    @Override
    public ErrorDTO isPurchaseRegisterApproved(PurchaseRegisterServiceRequest purchaseRegisterServiceRequest) {
        ErrorDTO errorDTO = null;
        PurchaseRegisterDTO purchaseRegisterDTO = purchaseRegisterServiceRequest.getPurchaseRegisterDTO();
        PurchaseRegister purchaseRegister = purchaseRegisterRepo.findById(purchaseRegisterDTO.getId()).get();
        if (true == purchaseRegister.getApproved()) {
            errorDTO = new ErrorDTO("ERR_PR_102", "Operation not possible, Since it is approved.");
        }
        return errorDTO;
    }
}