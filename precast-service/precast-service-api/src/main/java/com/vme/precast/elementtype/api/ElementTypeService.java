package com.vme.precast.elementtype.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ElementTypeService extends BaseService {

	@FlowDescriptor(flow = "createElementType", request = "elementTypeServiceRequest", response = "elementTypeServiceResponse")
	public ElementTypeServiceResponse createElementType(ElementTypeServiceRequest elementTypeServiceRequest);

	@FlowDescriptor(flow = "getElementTypes", request = "elementTypeServiceRequest", response = "elementTypeServiceResponse")
	public ElementTypeServiceResponse getElementTypes(ElementTypeServiceRequest elementTypeServiceRequest);

	@FlowDescriptor(flow = "updateElementType", request = "elementTypeServiceRequest", response = "elementTypeServiceResponse")
	public ElementTypeServiceResponse updateElementType(ElementTypeServiceRequest elementTypeServiceRequest);

	@FlowDescriptor(flow = "deleteElementType", request = "elementTypeServiceRequest", response = "elementTypeServiceResponse")
	public ElementTypeServiceResponse deleteElementType(ElementTypeServiceRequest elementTypeServiceRequest);
}
