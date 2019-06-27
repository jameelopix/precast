package com.vme.precast.rawmaterial.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class RawMaterialServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<RawMaterialDTO> rawMaterialDTOList;

 public List<RawMaterialDTO> getRawMaterialDTOList() {
 return rawMaterialDTOList;
 }

 public void setRawMaterialDTOList(List<RawMaterialDTO> rawMaterialDTOList) {
 this.rawMaterialDTOList = rawMaterialDTOList;
 }
}