package com.vme.precast.element.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface ElementValidator extends ColiseumInterface {

	public ErrorDTO checkElementDuplicate(ElementServiceRequest elementServiceRequest);
}