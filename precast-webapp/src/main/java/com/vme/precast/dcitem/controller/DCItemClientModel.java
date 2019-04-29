package com.vme.precast.dcitem.controller;

import java.util.List;

import com.vme.precast.dcitem.api.DCItemDTO;
import com.vme.precast.dcitem.api.DCItemSearchDTO;

import coliseum.web.BaseClientModel;

public class DCItemClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private DCItemDTO dCItemDTO;

 private DCItemSearchDTO dCItemSearchDTO;

 private List<DCItemDTO> dCItemDTOList;

 public DCItemDTO getDCItemDTO() {
 return dCItemDTO;
 }

 public void setDCItemDTO(DCItemDTO dCItemDTO) {
 this.dCItemDTO = dCItemDTO;
 }

 public List<DCItemDTO> getDCItemDTOList() {
 return dCItemDTOList;
 }

 public void setDCItemDTOList(List<DCItemDTO> dCItemDTOList) {
 this.dCItemDTOList = dCItemDTOList;
 }

 public DCItemSearchDTO getDCItemSearchDTO() {
 return dCItemSearchDTO;
 }

 public void setDCItemSearchDTO(DCItemSearchDTO dCItemSearchDTO) {
 this.dCItemSearchDTO = dCItemSearchDTO;
 }

}