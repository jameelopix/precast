package com.vme.precast.elementtype.api;

import coliseum.service.BaseServiceRequest;

public class ElementTypeServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private ElementTypeDTO elementTypeDTO;

 private ElementTypeSearchDTO elementTypeSearchDTO;

 public ElementTypeDTO getElementTypeDTO() {
 return elementTypeDTO;
 }

 public void setElementTypeDTO(ElementTypeDTO elementTypeDTO) {
 this.elementTypeDTO = elementTypeDTO;
 }

 public ElementTypeSearchDTO getElementTypeSearchDTO() {
 return elementTypeSearchDTO;
 }

 public void setElementTypeSearchDTO(ElementTypeSearchDTO elementTypeSearchDTO) {
 this.elementTypeSearchDTO = elementTypeSearchDTO;
 }
}
