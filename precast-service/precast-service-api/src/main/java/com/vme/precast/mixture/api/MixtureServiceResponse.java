package com.vme.precast.mixture.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class MixtureServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<MixtureDTO> mixtureDTOList;

 public List<MixtureDTO> getMixtureDTOList() {
 return mixtureDTOList;
 }

 public void setMixtureDTOList(List<MixtureDTO> mixtureDTOList) {
 this.mixtureDTOList = mixtureDTOList;
 }
}