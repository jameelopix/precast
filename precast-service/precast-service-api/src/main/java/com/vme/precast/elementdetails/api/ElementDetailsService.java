package com.vme.precast.elementdetails.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ElementDetailsService extends BaseService {

 @FlowDescriptor(flow = "createelementdetails", request = "elementDetailsServiceRequest", response = "elementDetailsServiceResponse")
 public ElementDetailsServiceResponse createElementDetails(ElementDetailsServiceRequest elementDetailsServiceRequest);

 @FlowDescriptor(flow = "getelementdetailss", request = "elementDetailsServiceRequest", response = "elementDetailsServiceResponse")
 public ElementDetailsServiceResponse getElementDetailss(ElementDetailsServiceRequest elementDetailsServiceRequest);

 @FlowDescriptor(flow = "updateelementdetails", request = "elementDetailsServiceRequest", response = "elementDetailsServiceResponse")
 public ElementDetailsServiceResponse updateElementDetails(ElementDetailsServiceRequest elementDetailsServiceRequest);

 @FlowDescriptor(flow = "deleteelementdetails", request = "elementDetailsServiceRequest", response = "elementDetailsServiceResponse")
 public ElementDetailsServiceResponse deleteElementDetails(ElementDetailsServiceRequest elementDetailsServiceRequest);
}