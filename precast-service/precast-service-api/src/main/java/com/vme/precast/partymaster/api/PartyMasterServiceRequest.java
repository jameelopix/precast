package com.vme.precast.partymaster.api;

import coliseum.service.BaseServiceRequest;

public class PartyMasterServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private PartyMasterDTO partyMasterDTO;

 private PartyMasterSearchDTO partyMasterSearchDTO;

 public PartyMasterDTO getPartyMasterDTO() {
 return partyMasterDTO;
 }

 public void setPartyMasterDTO(PartyMasterDTO partyMasterDTO) {
 this.partyMasterDTO = partyMasterDTO;
 }

 public PartyMasterSearchDTO getPartyMasterSearchDTO() {
 return partyMasterSearchDTO;
 }

 public void setPartyMasterSearchDTO(PartyMasterSearchDTO partyMasterSearchDTO) {
 this.partyMasterSearchDTO = partyMasterSearchDTO;
 }
}
