package com.vme.precast.dcitem.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class DCItemServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<DCItemDTO> dCItemDTOList;

 public List<DCItemDTO> getDCItemDTOList() {
 return dCItemDTOList;
 }

 public void setDCItemDTOList(List<DCItemDTO> dCItemDTOList) {
 this.dCItemDTOList = dCItemDTOList;
 }
}