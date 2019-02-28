package com.vme.precast.elementtype.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface ElementTypeValidator extends ColiseumInterface {

	public ErrorDTO checkElementTypeDuplicate(ElementTypeServiceRequest elementTypeServiceRequest);
}
