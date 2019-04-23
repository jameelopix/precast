package com.vme.precast.vendor.api;

import coliseum.service.BaseServiceRequest;

public class VendorServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private VendorDTO vendorDTO;

 private VendorSearchDTO vendorSearchDTO;

 public VendorDTO getVendorDTO() {
 return vendorDTO;
 }

 public void setVendorDTO(VendorDTO vendorDTO) {
 this.vendorDTO = vendorDTO;
 }

 public VendorSearchDTO getVendorSearchDTO() {
 return vendorSearchDTO;
 }

 public void setVendorSearchDTO(VendorSearchDTO vendorSearchDTO) {
 this.vendorSearchDTO = vendorSearchDTO;
 }
}
