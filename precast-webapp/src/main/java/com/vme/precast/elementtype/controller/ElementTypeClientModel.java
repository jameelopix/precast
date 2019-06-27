package com.vme.precast.elementtype.controller;

import java.util.List;

import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.elementtype.api.ElementTypeSearchDTO;

import coliseum.web.BaseClientModel;

public class ElementTypeClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private ElementTypeDTO elementTypeDTO;

 private ElementTypeSearchDTO elementTypeSearchDTO;

 private List<ElementTypeDTO> elementTypeDTOList;

 public ElementTypeDTO getElementTypeDTO() {
 return elementTypeDTO;
 }

 public void setElementTypeDTO(ElementTypeDTO elementTypeDTO) {
 this.elementTypeDTO = elementTypeDTO;
 }

 public List<ElementTypeDTO> getElementTypeDTOList() {
 return elementTypeDTOList;
 }

 public void setElementTypeDTOList(List<ElementTypeDTO> elementTypeDTOList) {
 this.elementTypeDTOList = elementTypeDTOList;
 }

 public ElementTypeSearchDTO getElementTypeSearchDTO() {
 return elementTypeSearchDTO;
 }

 public void setElementTypeSearchDTO(ElementTypeSearchDTO elementTypeSearchDTO) {
 this.elementTypeSearchDTO = elementTypeSearchDTO;
 }

}