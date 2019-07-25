package com.vme.precast.labourworkentry.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface LabourWorkEntryValidator extends ColiseumInterface {

 public ErrorDTO checkLabourWorkEntryDuplicate(LabourWorkEntryServiceRequest labourWorkEntryServiceRequest);
}
