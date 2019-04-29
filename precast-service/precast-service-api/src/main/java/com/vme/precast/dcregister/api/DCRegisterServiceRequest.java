package com.vme.precast.dcregister.api;

import coliseum.service.BaseServiceRequest;

public class DCRegisterServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private DCRegisterDTO dCRegisterDTO;

 private DCRegisterSearchDTO dCRegisterSearchDTO;

 public DCRegisterDTO getDCRegisterDTO() {
 return dCRegisterDTO;
 }

 public void setDCRegisterDTO(DCRegisterDTO dCRegisterDTO) {
 this.dCRegisterDTO = dCRegisterDTO;
 }

 public DCRegisterSearchDTO getDCRegisterSearchDTO() {
 return dCRegisterSearchDTO;
 }

 public void setDCRegisterSearchDTO(DCRegisterSearchDTO dCRegisterSearchDTO) {
 this.dCRegisterSearchDTO = dCRegisterSearchDTO;
 }
}
