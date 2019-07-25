package com.vme.precast.subcontractor.api;

import coliseum.service.BaseServiceRequest;

public class SubContractorServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private SubContractorDTO subContractorDTO;

 private SubContractorSearchDTO subContractorSearchDTO;

 public SubContractorDTO getSubContractorDTO() {
 return subContractorDTO;
 }

 public void setSubContractorDTO(SubContractorDTO subContractorDTO) {
 this.subContractorDTO = subContractorDTO;
 }

 public SubContractorSearchDTO getSubContractorSearchDTO() {
 return subContractorSearchDTO;
 }

 public void setSubContractorSearchDTO(SubContractorSearchDTO subContractorSearchDTO) {
 this.subContractorSearchDTO = subContractorSearchDTO;
 }
}
