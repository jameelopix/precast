package com.vme.precast.steeldetails.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class SteelDetailsServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<SteelDetailsDTO> steelDetailsDTOList;

 public List<SteelDetailsDTO> getSteelDetailsDTOList() {
 return steelDetailsDTOList;
 }

 public void setSteelDetailsDTOList(List<SteelDetailsDTO> steelDetailsDTOList) {
 this.steelDetailsDTOList = steelDetailsDTOList;
 }
}