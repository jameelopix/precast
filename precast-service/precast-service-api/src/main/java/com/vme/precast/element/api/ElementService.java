package com.vme.precast.element.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ElementService extends BaseService {

	@FlowDescriptor(flow = "createElement", request = "elementServiceRequest", response = "elementServiceResponse")
	public ElementServiceResponse createElement(ElementServiceRequest elementServiceRequest);

	@FlowDescriptor(flow = "getElements", request = "elementServiceRequest", response = "elementServiceResponse")
	public ElementServiceResponse getElements(ElementServiceRequest elementServiceRequest);

	@FlowDescriptor(flow = "updateElement", request = "elementServiceRequest", response = "elementServiceResponse")
	public ElementServiceResponse updateElement(ElementServiceRequest elementServiceRequest);

	@FlowDescriptor(flow = "deleteElement", request = "elementServiceRequest", response = "elementServiceResponse")
	public ElementServiceResponse deleteElement(ElementServiceRequest elementServiceRequest);
}