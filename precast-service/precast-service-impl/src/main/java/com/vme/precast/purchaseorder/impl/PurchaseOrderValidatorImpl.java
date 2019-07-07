package com.vme.precast.purchaseorder.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.PurchaseOrder;
import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;
import com.vme.precast.purchaseorder.api.PurchaseOrderServiceRequest;
import com.vme.precast.purchaseorder.api.PurchaseOrderValidator;
import com.vme.precast.repository.PurchaseOrderRepo;
import com.vme.precast.shared.PurchaseOrderStatus;

import coliseum.service.ErrorDTO;

public class PurchaseOrderValidatorImpl implements PurchaseOrderValidator {
    @Autowired
    PurchaseOrderRepo purchaseOrderRepo;

    @Override
    public ErrorDTO checkPurchaseOrderDuplicate(PurchaseOrderServiceRequest purchaseOrderServiceRequest) {
        return null;
    }

    @Override
    public ErrorDTO isPurchaseOrderClosed(PurchaseOrderServiceRequest purchaseOrderServiceRequest) {
        ErrorDTO errorDTO = null;
        PurchaseOrderDTO purchaseOrderDTO = purchaseOrderServiceRequest.getPurchaseOrderDTO();
        PurchaseOrder purchaseOrder = purchaseOrderRepo.findById(purchaseOrderDTO.getId()).get();
        if (PurchaseOrderStatus.CLOSED.equals(purchaseOrder.getPurchaseOrderStatus())) {
            errorDTO = new ErrorDTO("ERR_PR_101", "Operation not possible, Since status is CLOSED.");
        }
        return errorDTO;
    }

    @Override
    public ErrorDTO isPurchaseOrderIssued(PurchaseOrderServiceRequest purchaseOrderServiceRequest) {
        ErrorDTO errorDTO = null;
        PurchaseOrderDTO purchaseOrderDTO = purchaseOrderServiceRequest.getPurchaseOrderDTO();
        PurchaseOrder purchaseOrder = purchaseOrderRepo.findById(purchaseOrderDTO.getId()).get();
        if (PurchaseOrderStatus.ISSUED.equals(purchaseOrder.getPurchaseOrderStatus())) {
            errorDTO = new ErrorDTO("ERR_PR_102", "Operation not possible, Since status is ISSUED.");
        }
        return errorDTO;
    }
}