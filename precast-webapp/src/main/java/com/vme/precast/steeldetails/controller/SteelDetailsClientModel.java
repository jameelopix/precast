package com.vme.precast.steeldetails.controller;

import java.util.List;

import com.vme.precast.steeldetails.api.SteelDetailsDTO;
import com.vme.precast.steeldetails.api.SteelDetailsSearchDTO;

import coliseum.web.BaseClientModel;

public class SteelDetailsClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private SteelDetailsDTO steelDetailsDTO;

 private SteelDetailsSearchDTO steelDetailsSearchDTO;

 private List<SteelDetailsDTO> steelDetailsDTOList;

 public SteelDetailsDTO getSteelDetailsDTO() {
 return steelDetailsDTO;
 }

 public void setSteelDetailsDTO(SteelDetailsDTO steelDetailsDTO) {
 this.steelDetailsDTO = steelDetailsDTO;
 }

 public List<SteelDetailsDTO> getSteelDetailsDTOList() {
 return steelDetailsDTOList;
 }

 public void setSteelDetailsDTOList(List<SteelDetailsDTO> steelDetailsDTOList) {
 this.steelDetailsDTOList = steelDetailsDTOList;
 }

 public SteelDetailsSearchDTO getSteelDetailsSearchDTO() {
 return steelDetailsSearchDTO;
 }

 public void setSteelDetailsSearchDTO(SteelDetailsSearchDTO steelDetailsSearchDTO) {
 this.steelDetailsSearchDTO = steelDetailsSearchDTO;
 }

}