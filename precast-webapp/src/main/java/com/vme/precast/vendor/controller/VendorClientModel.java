package com.vme.precast.vendor.controller;

import java.util.List;

import com.vme.precast.vendor.api.VendorDTO;
import com.vme.precast.vendor.api.VendorSearchDTO;

import coliseum.web.BaseClientModel;

public class VendorClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private VendorDTO vendorDTO;

 private VendorSearchDTO vendorSearchDTO;

 private List<VendorDTO> vendorDTOList;

 public VendorDTO getVendorDTO() {
 return vendorDTO;
 }

 public void setVendorDTO(VendorDTO vendorDTO) {
 this.vendorDTO = vendorDTO;
 }

 public List<VendorDTO> getVendorDTOList() {
 return vendorDTOList;
 }

 public void setVendorDTOList(List<VendorDTO> vendorDTOList) {
 this.vendorDTOList = vendorDTOList;
 }

 public VendorSearchDTO getVendorSearchDTO() {
 return vendorSearchDTO;
 }

 public void setVendorSearchDTO(VendorSearchDTO vendorSearchDTO) {
 this.vendorSearchDTO = vendorSearchDTO;
 }

}