package com.vme.precast.elementdetails.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ElementDetailsServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<ElementDetailsDTO> elementDetailsDTOList;

 public List<ElementDetailsDTO> getElementDetailsDTOList() {
 return elementDetailsDTOList;
 }

 public void setElementDetailsDTOList(List<ElementDetailsDTO> elementDetailsDTOList) {
 this.elementDetailsDTOList = elementDetailsDTOList;
 }
}