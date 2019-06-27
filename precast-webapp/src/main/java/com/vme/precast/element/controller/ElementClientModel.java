package com.vme.precast.element.controller;

import java.util.List;

import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.element.api.ElementSearchDTO;

import coliseum.web.BaseClientModel;

public class ElementClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private ElementDTO elementDTO;

 private ElementSearchDTO elementSearchDTO;

 private List<ElementDTO> elementDTOList;

 public ElementDTO getElementDTO() {
 return elementDTO;
 }

 public void setElementDTO(ElementDTO elementDTO) {
 this.elementDTO = elementDTO;
 }

 public List<ElementDTO> getElementDTOList() {
 return elementDTOList;
 }

 public void setElementDTOList(List<ElementDTO> elementDTOList) {
 this.elementDTOList = elementDTOList;
 }

 public ElementSearchDTO getElementSearchDTO() {
 return elementSearchDTO;
 }

 public void setElementSearchDTO(ElementSearchDTO elementSearchDTO) {
 this.elementSearchDTO = elementSearchDTO;
 }

}