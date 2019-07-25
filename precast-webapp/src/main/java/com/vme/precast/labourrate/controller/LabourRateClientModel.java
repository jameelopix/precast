package com.vme.precast.labourrate.controller;

import java.util.List;

import com.vme.precast.labourrate.api.LabourRateDTO;
import com.vme.precast.labourrate.api.LabourRateSearchDTO;

import coliseum.web.BaseClientModel;

public class LabourRateClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private LabourRateDTO labourRateDTO;

 private LabourRateSearchDTO labourRateSearchDTO;

 private List<LabourRateDTO> labourRateDTOList;

 public LabourRateDTO getLabourRateDTO() {
 return labourRateDTO;
 }

 public void setLabourRateDTO(LabourRateDTO labourRateDTO) {
 this.labourRateDTO = labourRateDTO;
 }

 public List<LabourRateDTO> getLabourRateDTOList() {
 return labourRateDTOList;
 }

 public void setLabourRateDTOList(List<LabourRateDTO> labourRateDTOList) {
 this.labourRateDTOList = labourRateDTOList;
 }

 public LabourRateSearchDTO getLabourRateSearchDTO() {
 return labourRateSearchDTO;
 }

 public void setLabourRateSearchDTO(LabourRateSearchDTO labourRateSearchDTO) {
 this.labourRateSearchDTO = labourRateSearchDTO;
 }

}