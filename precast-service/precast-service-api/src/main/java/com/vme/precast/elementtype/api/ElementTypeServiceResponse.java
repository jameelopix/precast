package com.vme.precast.elementtype.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ElementTypeServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<ElementTypeDTO> elementTypeDTOList;

 public List<ElementTypeDTO> getElementTypeDTOList() {
 return elementTypeDTOList;
 }

 public void setElementTypeDTOList(List<ElementTypeDTO> elementTypeDTOList) {
 this.elementTypeDTOList = elementTypeDTOList;
 }
}