package com.vme.precast.element.api;

import coliseum.service.ColiseumInterface;

public interface ElementComponent extends ColiseumInterface {

	public ElementServiceResponse createElement(ElementServiceRequest elementServiceRequest);

	public ElementServiceResponse getElements(ElementServiceRequest elementServiceRequest);

	public ElementServiceResponse updateElement(ElementServiceRequest elementServiceRequest);

	public ElementServiceResponse deleteElement(ElementServiceRequest elementServiceRequest);
}