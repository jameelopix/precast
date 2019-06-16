package com.vme.precast.partymaster.api;

import coliseum.service.ColiseumInterface;

public interface PartyMasterComponent extends ColiseumInterface {

 public PartyMasterServiceResponse createPartyMaster(PartyMasterServiceRequest partyMasterServiceRequest);

 public PartyMasterServiceResponse getPartyMasters(PartyMasterServiceRequest partyMasterServiceRequest);

 public PartyMasterServiceResponse updatePartyMaster(PartyMasterServiceRequest partyMasterServiceRequest);

 public PartyMasterServiceResponse deletePartyMaster(PartyMasterServiceRequest partyMasterServiceRequest);
}
