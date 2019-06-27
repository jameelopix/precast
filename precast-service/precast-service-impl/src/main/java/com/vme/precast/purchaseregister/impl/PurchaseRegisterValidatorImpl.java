package com.vme.precast.purchaseregister.impl;

import org.springframework.beans.factory.annotation.Autowired;

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
}