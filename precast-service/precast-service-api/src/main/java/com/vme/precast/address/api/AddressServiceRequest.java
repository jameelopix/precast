package com.vme.precast.address.api;

import coliseum.service.BaseServiceRequest;

public class AddressServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private AddressDTO addressDTO;

 private AddressSearchDTO addressSearchDTO;

 public AddressDTO getAddressDTO() {
 return addressDTO;
 }

 public void setAddressDTO(AddressDTO addressDTO) {
 this.addressDTO = addressDTO;
 }

 public AddressSearchDTO getAddressSearchDTO() {
 return addressSearchDTO;
 }

 public void setAddressSearchDTO(AddressSearchDTO addressSearchDTO) {
 this.addressSearchDTO = addressSearchDTO;
 }
}
