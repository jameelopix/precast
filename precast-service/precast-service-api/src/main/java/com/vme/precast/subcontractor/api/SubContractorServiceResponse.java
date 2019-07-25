package com.vme.precast.subcontractor.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class SubContractorServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<SubContractorDTO> subContractorDTOList;

 public List<SubContractorDTO> getSubContractorDTOList() {
 return subContractorDTOList;
 }

 public void setSubContractorDTOList(List<SubContractorDTO> subContractorDTOList) {
 this.subContractorDTOList = subContractorDTOList;
 }
}