package com.vme.precast.elementdetails.api;

import coliseum.service.BaseServiceRequest;

public class ElementDetailsServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private ElementDetailsDTO elementDetailsDTO;

 private ElementDetailsSearchDTO elementDetailsSearchDTO;

 public ElementDetailsDTO getElementDetailsDTO() {
 return elementDetailsDTO;
 }

 public void setElementDetailsDTO(ElementDetailsDTO elementDetailsDTO) {
 this.elementDetailsDTO = elementDetailsDTO;
 }

 public ElementDetailsSearchDTO getElementDetailsSearchDTO() {
 return elementDetailsSearchDTO;
 }

 public void setElementDetailsSearchDTO(ElementDetailsSearchDTO elementDetailsSearchDTO) {
 this.elementDetailsSearchDTO = elementDetailsSearchDTO;
 }
}
