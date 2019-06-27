package com.vme.precast.mixture.controller;

import java.util.List;

import com.vme.precast.mixture.api.MixtureDTO;
import com.vme.precast.mixture.api.MixtureSearchDTO;

import coliseum.web.BaseClientModel;

public class MixtureClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private MixtureDTO mixtureDTO;

 private MixtureSearchDTO mixtureSearchDTO;

 private List<MixtureDTO> mixtureDTOList;

 public MixtureDTO getMixtureDTO() {
 return mixtureDTO;
 }

 public void setMixtureDTO(MixtureDTO mixtureDTO) {
 this.mixtureDTO = mixtureDTO;
 }

 public List<MixtureDTO> getMixtureDTOList() {
 return mixtureDTOList;
 }

 public void setMixtureDTOList(List<MixtureDTO> mixtureDTOList) {
 this.mixtureDTOList = mixtureDTOList;
 }

 public MixtureSearchDTO getMixtureSearchDTO() {
 return mixtureSearchDTO;
 }

 public void setMixtureSearchDTO(MixtureSearchDTO mixtureSearchDTO) {
 this.mixtureSearchDTO = mixtureSearchDTO;
 }

}