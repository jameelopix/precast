package com.vme.precast.mixtureitem.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class MixtureItemServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<MixtureItemDTO> mixtureItemDTOList;

 public List<MixtureItemDTO> getMixtureItemDTOList() {
 return mixtureItemDTOList;
 }

 public void setMixtureItemDTOList(List<MixtureItemDTO> mixtureItemDTOList) {
 this.mixtureItemDTOList = mixtureItemDTOList;
 }
}