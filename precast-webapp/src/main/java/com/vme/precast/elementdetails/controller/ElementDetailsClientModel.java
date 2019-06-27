package com.vme.precast.elementdetails.controller;

import java.util.List;

import com.vme.precast.elementdetails.api.ElementDetailsDTO;
import com.vme.precast.elementdetails.api.ElementDetailsSearchDTO;

import coliseum.web.BaseClientModel;

public class ElementDetailsClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private ElementDetailsDTO elementDetailsDTO;

 private ElementDetailsSearchDTO elementDetailsSearchDTO;

 private List<ElementDetailsDTO> elementDetailsDTOList;

 public ElementDetailsDTO getElementDetailsDTO() {
 return elementDetailsDTO;
 }

 public void setElementDetailsDTO(ElementDetailsDTO elementDetailsDTO) {
 this.elementDetailsDTO = elementDetailsDTO;
 }

 public List<ElementDetailsDTO> getElementDetailsDTOList() {
 return elementDetailsDTOList;
 }

 public void setElementDetailsDTOList(List<ElementDetailsDTO> elementDetailsDTOList) {
 this.elementDetailsDTOList = elementDetailsDTOList;
 }

 public ElementDetailsSearchDTO getElementDetailsSearchDTO() {
 return elementDetailsSearchDTO;
 }

 public void setElementDetailsSearchDTO(ElementDetailsSearchDTO elementDetailsSearchDTO) {
 this.elementDetailsSearchDTO = elementDetailsSearchDTO;
 }

}