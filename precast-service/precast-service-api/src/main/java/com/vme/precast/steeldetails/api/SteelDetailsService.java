package com.vme.precast.steeldetails.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface SteelDetailsService extends BaseService {

 @FlowDescriptor(flow = "createsteeldetails", request = "steelDetailsServiceRequest", response = "steelDetailsServiceResponse")
 public SteelDetailsServiceResponse createSteelDetails(SteelDetailsServiceRequest steelDetailsServiceRequest);

 @FlowDescriptor(flow = "getsteeldetailss", request = "steelDetailsServiceRequest", response = "steelDetailsServiceResponse")
 public SteelDetailsServiceResponse getSteelDetailss(SteelDetailsServiceRequest steelDetailsServiceRequest);

 @FlowDescriptor(flow = "updatesteeldetails", request = "steelDetailsServiceRequest", response = "steelDetailsServiceResponse")
 public SteelDetailsServiceResponse updateSteelDetails(SteelDetailsServiceRequest steelDetailsServiceRequest);

 @FlowDescriptor(flow = "deletesteeldetails", request = "steelDetailsServiceRequest", response = "steelDetailsServiceResponse")
 public SteelDetailsServiceResponse deleteSteelDetails(SteelDetailsServiceRequest steelDetailsServiceRequest);
}