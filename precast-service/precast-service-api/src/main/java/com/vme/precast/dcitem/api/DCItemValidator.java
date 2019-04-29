package com.vme.precast.dcitem.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface DCItemValidator extends ColiseumInterface {

 public ErrorDTO checkDCItemDuplicate(DCItemServiceRequest dCItemServiceRequest);
}
