package com.vme.precast.vendor.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.vendor.api.VendorServiceRequest;
import com.vme.precast.vendor.api.VendorValidator;
import com.vme.precast.repository.VendorRepo;

import coliseum.service.ErrorDTO;

public class VendorValidatorImpl implements VendorValidator {
 @Autowired
 VendorRepo vendorRepo;

 @Override
 public ErrorDTO checkVendorDuplicate(VendorServiceRequest vendorServiceRequest) {
 return null;
 }
}