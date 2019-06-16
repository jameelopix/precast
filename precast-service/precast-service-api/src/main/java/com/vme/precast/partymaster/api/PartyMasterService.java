package com.vme.precast.partymaster.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface PartyMasterService extends BaseService {

 @FlowDescriptor(flow = "createpartymaster", request = "partyMasterServiceRequest", response = "partyMasterServiceResponse")
 public PartyMasterServiceResponse createPartyMaster(PartyMasterServiceRequest partyMasterServiceRequest);

 @FlowDescriptor(flow = "getpartymasters", request = "partyMasterServiceRequest", response = "partyMasterServiceResponse")
 public PartyMasterServiceResponse getPartyMasters(PartyMasterServiceRequest partyMasterServiceRequest);

 @FlowDescriptor(flow = "updatepartymaster", request = "partyMasterServiceRequest", response = "partyMasterServiceResponse")
 public PartyMasterServiceResponse updatePartyMaster(PartyMasterServiceRequest partyMasterServiceRequest);

 @FlowDescriptor(flow = "deletepartymaster", request = "partyMasterServiceRequest", response = "partyMasterServiceResponse")
 public PartyMasterServiceResponse deletePartyMaster(PartyMasterServiceRequest partyMasterServiceRequest);
}