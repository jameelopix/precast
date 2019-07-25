package com.vme.precast.labourrate.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface LabourRateValidator extends ColiseumInterface {

 public ErrorDTO checkLabourRateDuplicate(LabourRateServiceRequest labourRateServiceRequest);
}
