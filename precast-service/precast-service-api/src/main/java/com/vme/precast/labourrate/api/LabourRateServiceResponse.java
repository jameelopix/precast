package com.vme.precast.labourrate.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class LabourRateServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<LabourRateDTO> labourRateDTOList;

 public List<LabourRateDTO> getLabourRateDTOList() {
 return labourRateDTOList;
 }

 public void setLabourRateDTOList(List<LabourRateDTO> labourRateDTOList) {
 this.labourRateDTOList = labourRateDTOList;
 }
}