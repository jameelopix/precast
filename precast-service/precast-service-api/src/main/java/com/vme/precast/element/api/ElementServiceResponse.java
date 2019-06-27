package com.vme.precast.element.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ElementServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<ElementDTO> elementDTOList;

 public List<ElementDTO> getElementDTOList() {
 return elementDTOList;
 }

 public void setElementDTOList(List<ElementDTO> elementDTOList) {
 this.elementDTOList = elementDTOList;
 }
}