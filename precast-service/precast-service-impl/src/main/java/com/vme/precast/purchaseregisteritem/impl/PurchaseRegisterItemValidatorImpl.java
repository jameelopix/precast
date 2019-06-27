package com.vme.precast.purchaseregisteritem.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemServiceRequest;
import com.vme.precast.purchaseregisteritem.api.PurchaseRegisterItemValidator;
import com.vme.precast.repository.PurchaseRegisterItemRepo;

import coliseum.service.ErrorDTO;

public class PurchaseRegisterItemValidatorImpl implements PurchaseRegisterItemValidator {
 @Autowired
 PurchaseRegisterItemRepo purchaseRegisterItemRepo;

 @Override
 public ErrorDTO checkPurchaseRegisterItemDuplicate(PurchaseRegisterItemServiceRequest purchaseRegisterItemServiceRequest) {
 return null;
 }
}