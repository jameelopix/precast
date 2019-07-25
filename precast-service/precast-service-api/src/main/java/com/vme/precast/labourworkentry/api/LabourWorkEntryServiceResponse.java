package com.vme.precast.labourworkentry.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class LabourWorkEntryServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<LabourWorkEntryDTO> labourWorkEntryDTOList;

 public List<LabourWorkEntryDTO> getLabourWorkEntryDTOList() {
 return labourWorkEntryDTOList;
 }

 public void setLabourWorkEntryDTOList(List<LabourWorkEntryDTO> labourWorkEntryDTOList) {
 this.labourWorkEntryDTOList = labourWorkEntryDTOList;
 }
}