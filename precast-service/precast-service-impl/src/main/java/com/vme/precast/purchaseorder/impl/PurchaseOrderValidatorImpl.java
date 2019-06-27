package com.vme.precast.purchaseorder.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.purchaseorder.api.PurchaseOrderServiceRequest;
import com.vme.precast.purchaseorder.api.PurchaseOrderValidator;
import com.vme.precast.repository.PurchaseOrderRepo;

import coliseum.service.ErrorDTO;

public class PurchaseOrderValidatorImpl implements PurchaseOrderValidator {
 @Autowired
 PurchaseOrderRepo purchaseOrderRepo;

 @Override
 public ErrorDTO checkPurchaseOrderDuplicate(PurchaseOrderServiceRequest purchaseOrderServiceRequest) {
 return null;
 }
}