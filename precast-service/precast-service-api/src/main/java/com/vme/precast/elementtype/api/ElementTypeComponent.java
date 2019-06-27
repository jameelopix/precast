package com.vme.precast.elementtype.api;

import coliseum.service.ColiseumInterface;

public interface ElementTypeComponent extends ColiseumInterface {

 public ElementTypeServiceResponse createElementType(ElementTypeServiceRequest elementTypeServiceRequest);

 public ElementTypeServiceResponse getElementTypes(ElementTypeServiceRequest elementTypeServiceRequest);

 public ElementTypeServiceResponse updateElementType(ElementTypeServiceRequest elementTypeServiceRequest);

 public ElementTypeServiceResponse deleteElementType(ElementTypeServiceRequest elementTypeServiceRequest);
}
