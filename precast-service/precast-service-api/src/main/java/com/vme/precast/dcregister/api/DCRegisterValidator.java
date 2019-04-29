package com.vme.precast.dcregister.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface DCRegisterValidator extends ColiseumInterface {

 public ErrorDTO checkDCRegisterDuplicate(DCRegisterServiceRequest dCRegisterServiceRequest);
}
