package com.vme.precast.partymaster.controller;

import java.util.List;

import com.vme.precast.partymaster.api.PartyMasterDTO;
import com.vme.precast.partymaster.api.PartyMasterSearchDTO;

import coliseum.web.BaseClientModel;

public class PartyMasterClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private PartyMasterDTO partyMasterDTO;

 private PartyMasterSearchDTO partyMasterSearchDTO;

 private List<PartyMasterDTO> partyMasterDTOList;

 public PartyMasterDTO getPartyMasterDTO() {
 return partyMasterDTO;
 }

 public void setPartyMasterDTO(PartyMasterDTO partyMasterDTO) {
 this.partyMasterDTO = partyMasterDTO;
 }

 public List<PartyMasterDTO> getPartyMasterDTOList() {
 return partyMasterDTOList;
 }

 public void setPartyMasterDTOList(List<PartyMasterDTO> partyMasterDTOList) {
 this.partyMasterDTOList = partyMasterDTOList;
 }

 public PartyMasterSearchDTO getPartyMasterSearchDTO() {
 return partyMasterSearchDTO;
 }

 public void setPartyMasterSearchDTO(PartyMasterSearchDTO partyMasterSearchDTO) {
 this.partyMasterSearchDTO = partyMasterSearchDTO;
 }

}