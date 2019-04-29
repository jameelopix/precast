package com.vme.precast.dcregister.controller;

import java.util.List;

import com.vme.precast.dcregister.api.DCRegisterDTO;
import com.vme.precast.dcregister.api.DCRegisterSearchDTO;

import coliseum.web.BaseClientModel;

public class DCRegisterClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private DCRegisterDTO dCRegisterDTO;

 private DCRegisterSearchDTO dCRegisterSearchDTO;

 private List<DCRegisterDTO> dCRegisterDTOList;

 public DCRegisterDTO getDCRegisterDTO() {
 return dCRegisterDTO;
 }

 public void setDCRegisterDTO(DCRegisterDTO dCRegisterDTO) {
 this.dCRegisterDTO = dCRegisterDTO;
 }

 public List<DCRegisterDTO> getDCRegisterDTOList() {
 return dCRegisterDTOList;
 }

 public void setDCRegisterDTOList(List<DCRegisterDTO> dCRegisterDTOList) {
 this.dCRegisterDTOList = dCRegisterDTOList;
 }

 public DCRegisterSearchDTO getDCRegisterSearchDTO() {
 return dCRegisterSearchDTO;
 }

 public void setDCRegisterSearchDTO(DCRegisterSearchDTO dCRegisterSearchDTO) {
 this.dCRegisterSearchDTO = dCRegisterSearchDTO;
 }

}