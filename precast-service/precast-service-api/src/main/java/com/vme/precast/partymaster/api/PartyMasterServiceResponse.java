package com.vme.precast.partymaster.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class PartyMasterServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<PartyMasterDTO> partyMasterDTOList;

 public List<PartyMasterDTO> getPartyMasterDTOList() {
 return partyMasterDTOList;
 }

 public void setPartyMasterDTOList(List<PartyMasterDTO> partyMasterDTOList) {
 this.partyMasterDTOList = partyMasterDTOList;
 }
}