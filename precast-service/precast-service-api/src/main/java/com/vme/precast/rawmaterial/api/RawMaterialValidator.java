package com.vme.precast.rawmaterial.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface RawMaterialValidator extends ColiseumInterface {

 public ErrorDTO checkRawMaterialDuplicate(RawMaterialServiceRequest rawMaterialServiceRequest);
}
