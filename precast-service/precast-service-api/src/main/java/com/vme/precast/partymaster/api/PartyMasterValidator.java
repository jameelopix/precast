package com.vme.precast.partymaster.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface PartyMasterValidator extends ColiseumInterface {

 public ErrorDTO checkPartyMasterDuplicate(PartyMasterServiceRequest partyMasterServiceRequest);
}
