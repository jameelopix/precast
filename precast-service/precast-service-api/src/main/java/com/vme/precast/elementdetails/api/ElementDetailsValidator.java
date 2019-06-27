package com.vme.precast.elementdetails.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface ElementDetailsValidator extends ColiseumInterface {

 public ErrorDTO checkElementDetailsDuplicate(ElementDetailsServiceRequest elementDetailsServiceRequest);
}
