package com.vme.precast.purchaseorderitem.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemServiceRequest;
import com.vme.precast.purchaseorderitem.api.PurchaseOrderItemValidator;
import com.vme.precast.repository.PurchaseOrderItemRepo;

import coliseum.service.ErrorDTO;

public class PurchaseOrderItemValidatorImpl implements PurchaseOrderItemValidator {
 @Autowired
 PurchaseOrderItemRepo purchaseOrderItemRepo;

 @Override
 public ErrorDTO checkPurchaseOrderItemDuplicate(PurchaseOrderItemServiceRequest purchaseOrderItemServiceRequest) {
 return null;
 }
}