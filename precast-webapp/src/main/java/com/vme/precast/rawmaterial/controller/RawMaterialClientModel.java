package com.vme.precast.rawmaterial.controller;

import java.util.List;

import com.vme.precast.rawmaterial.api.RawMaterialDTO;
import com.vme.precast.rawmaterial.api.RawMaterialSearchDTO;

import coliseum.web.BaseClientModel;

public class RawMaterialClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private RawMaterialDTO rawMaterialDTO;

 private RawMaterialSearchDTO rawMaterialSearchDTO;

 private List<RawMaterialDTO> rawMaterialDTOList;

 public RawMaterialDTO getRawMaterialDTO() {
 return rawMaterialDTO;
 }

 public void setRawMaterialDTO(RawMaterialDTO rawMaterialDTO) {
 this.rawMaterialDTO = rawMaterialDTO;
 }

 public List<RawMaterialDTO> getRawMaterialDTOList() {
 return rawMaterialDTOList;
 }

 public void setRawMaterialDTOList(List<RawMaterialDTO> rawMaterialDTOList) {
 this.rawMaterialDTOList = rawMaterialDTOList;
 }

 public RawMaterialSearchDTO getRawMaterialSearchDTO() {
 return rawMaterialSearchDTO;
 }

 public void setRawMaterialSearchDTO(RawMaterialSearchDTO rawMaterialSearchDTO) {
 this.rawMaterialSearchDTO = rawMaterialSearchDTO;
 }

}