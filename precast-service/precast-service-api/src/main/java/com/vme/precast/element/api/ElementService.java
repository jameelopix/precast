package com.vme.precast.element.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ElementService extends BaseService {

 @FlowDescriptor(flow = "createelement", request = "elementServiceRequest", response = "elementServiceResponse")
 public ElementServiceResponse createElement(ElementServiceRequest elementServiceRequest);

 @FlowDescriptor(flow = "getelements", request = "elementServiceRequest", response = "elementServiceResponse")
 public ElementServiceResponse getElements(ElementServiceRequest elementServiceRequest);

 @FlowDescriptor(flow = "updateelement", request = "elementServiceRequest", response = "elementServiceResponse")
 public ElementServiceResponse updateElement(ElementServiceRequest elementServiceRequest);

 @FlowDescriptor(flow = "deleteelement", request = "elementServiceRequest", response = "elementServiceResponse")
 public ElementServiceResponse deleteElement(ElementServiceRequest elementServiceRequest);
}