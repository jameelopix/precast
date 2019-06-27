package com.vme.precast.mixtureitem.controller;

import java.util.List;

import com.vme.precast.mixtureitem.api.MixtureItemDTO;
import com.vme.precast.mixtureitem.api.MixtureItemSearchDTO;

import coliseum.web.BaseClientModel;

public class MixtureItemClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private MixtureItemDTO mixtureItemDTO;

 private MixtureItemSearchDTO mixtureItemSearchDTO;

 private List<MixtureItemDTO> mixtureItemDTOList;

 public MixtureItemDTO getMixtureItemDTO() {
 return mixtureItemDTO;
 }

 public void setMixtureItemDTO(MixtureItemDTO mixtureItemDTO) {
 this.mixtureItemDTO = mixtureItemDTO;
 }

 public List<MixtureItemDTO> getMixtureItemDTOList() {
 return mixtureItemDTOList;
 }

 public void setMixtureItemDTOList(List<MixtureItemDTO> mixtureItemDTOList) {
 this.mixtureItemDTOList = mixtureItemDTOList;
 }

 public MixtureItemSearchDTO getMixtureItemSearchDTO() {
 return mixtureItemSearchDTO;
 }

 public void setMixtureItemSearchDTO(MixtureItemSearchDTO mixtureItemSearchDTO) {
 this.mixtureItemSearchDTO = mixtureItemSearchDTO;
 }

}