package com.vme.precast.elementtype.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ElementTypeService extends BaseService {

 @FlowDescriptor(flow = "createelementtype", request = "elementTypeServiceRequest", response = "elementTypeServiceResponse")
 public ElementTypeServiceResponse createElementType(ElementTypeServiceRequest elementTypeServiceRequest);

 @FlowDescriptor(flow = "getelementtypes", request = "elementTypeServiceRequest", response = "elementTypeServiceResponse")
 public ElementTypeServiceResponse getElementTypes(ElementTypeServiceRequest elementTypeServiceRequest);

 @FlowDescriptor(flow = "updateelementtype", request = "elementTypeServiceRequest", response = "elementTypeServiceResponse")
 public ElementTypeServiceResponse updateElementType(ElementTypeServiceRequest elementTypeServiceRequest);

 @FlowDescriptor(flow = "deleteelementtype", request = "elementTypeServiceRequest", response = "elementTypeServiceResponse")
 public ElementTypeServiceResponse deleteElementType(ElementTypeServiceRequest elementTypeServiceRequest);
}