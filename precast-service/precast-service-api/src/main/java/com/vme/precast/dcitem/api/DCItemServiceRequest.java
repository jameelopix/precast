package com.vme.precast.dcitem.api;

import coliseum.service.BaseServiceRequest;

public class DCItemServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private DCItemDTO dCItemDTO;

 private DCItemSearchDTO dCItemSearchDTO;

 public DCItemDTO getDCItemDTO() {
 return dCItemDTO;
 }

 public void setDCItemDTO(DCItemDTO dCItemDTO) {
 this.dCItemDTO = dCItemDTO;
 }

 public DCItemSearchDTO getDCItemSearchDTO() {
 return dCItemSearchDTO;
 }

 public void setDCItemSearchDTO(DCItemSearchDTO dCItemSearchDTO) {
 this.dCItemSearchDTO = dCItemSearchDTO;
 }
}
