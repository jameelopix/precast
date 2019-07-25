package com.vme.precast.labourworkentry.api;

import coliseum.service.BaseServiceRequest;

public class LabourWorkEntryServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private LabourWorkEntryDTO labourWorkEntryDTO;

 private LabourWorkEntrySearchDTO labourWorkEntrySearchDTO;

 public LabourWorkEntryDTO getLabourWorkEntryDTO() {
 return labourWorkEntryDTO;
 }

 public void setLabourWorkEntryDTO(LabourWorkEntryDTO labourWorkEntryDTO) {
 this.labourWorkEntryDTO = labourWorkEntryDTO;
 }

 public LabourWorkEntrySearchDTO getLabourWorkEntrySearchDTO() {
 return labourWorkEntrySearchDTO;
 }

 public void setLabourWorkEntrySearchDTO(LabourWorkEntrySearchDTO labourWorkEntrySearchDTO) {
 this.labourWorkEntrySearchDTO = labourWorkEntrySearchDTO;
 }
}
