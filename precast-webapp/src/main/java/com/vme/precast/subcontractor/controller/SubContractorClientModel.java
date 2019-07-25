package com.vme.precast.subcontractor.controller;

import java.util.List;

import com.vme.precast.subcontractor.api.SubContractorDTO;
import com.vme.precast.subcontractor.api.SubContractorSearchDTO;

import coliseum.web.BaseClientModel;

public class SubContractorClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private SubContractorDTO subContractorDTO;

 private SubContractorSearchDTO subContractorSearchDTO;

 private List<SubContractorDTO> subContractorDTOList;

 public SubContractorDTO getSubContractorDTO() {
 return subContractorDTO;
 }

 public void setSubContractorDTO(SubContractorDTO subContractorDTO) {
 this.subContractorDTO = subContractorDTO;
 }

 public List<SubContractorDTO> getSubContractorDTOList() {
 return subContractorDTOList;
 }

 public void setSubContractorDTOList(List<SubContractorDTO> subContractorDTOList) {
 this.subContractorDTOList = subContractorDTOList;
 }

 public SubContractorSearchDTO getSubContractorSearchDTO() {
 return subContractorSearchDTO;
 }

 public void setSubContractorSearchDTO(SubContractorSearchDTO subContractorSearchDTO) {
 this.subContractorSearchDTO = subContractorSearchDTO;
 }

}