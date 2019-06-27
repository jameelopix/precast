package com.vme.precast.steeldetails.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface SteelDetailsValidator extends ColiseumInterface {

 public ErrorDTO checkSteelDetailsDuplicate(SteelDetailsServiceRequest steelDetailsServiceRequest);
}
