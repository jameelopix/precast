package com.vme.precast.labourworkentry.controller;

import java.util.List;

import com.vme.precast.labourworkentry.api.LabourWorkEntryDTO;
import com.vme.precast.labourworkentry.api.LabourWorkEntrySearchDTO;

import coliseum.web.BaseClientModel;

public class LabourWorkEntryClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private LabourWorkEntryDTO labourWorkEntryDTO;

 private LabourWorkEntrySearchDTO labourWorkEntrySearchDTO;

 private List<LabourWorkEntryDTO> labourWorkEntryDTOList;

 public LabourWorkEntryDTO getLabourWorkEntryDTO() {
 return labourWorkEntryDTO;
 }

 public void setLabourWorkEntryDTO(LabourWorkEntryDTO labourWorkEntryDTO) {
 this.labourWorkEntryDTO = labourWorkEntryDTO;
 }

 public List<LabourWorkEntryDTO> getLabourWorkEntryDTOList() {
 return labourWorkEntryDTOList;
 }

 public void setLabourWorkEntryDTOList(List<LabourWorkEntryDTO> labourWorkEntryDTOList) {
 this.labourWorkEntryDTOList = labourWorkEntryDTOList;
 }

 public LabourWorkEntrySearchDTO getLabourWorkEntrySearchDTO() {
 return labourWorkEntrySearchDTO;
 }

 public void setLabourWorkEntrySearchDTO(LabourWorkEntrySearchDTO labourWorkEntrySearchDTO) {
 this.labourWorkEntrySearchDTO = labourWorkEntrySearchDTO;
 }

}