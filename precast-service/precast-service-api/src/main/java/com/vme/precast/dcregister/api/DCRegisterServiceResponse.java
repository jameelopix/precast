package com.vme.precast.dcregister.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class DCRegisterServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<DCRegisterDTO> dCRegisterDTOList;

 public List<DCRegisterDTO> getDCRegisterDTOList() {
 return dCRegisterDTOList;
 }

 public void setDCRegisterDTOList(List<DCRegisterDTO> dCRegisterDTOList) {
 this.dCRegisterDTOList = dCRegisterDTOList;
 }
}