package com.vme.precast.mixtureitem.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface MixtureItemValidator extends ColiseumInterface {

 public ErrorDTO checkMixtureItemDuplicate(MixtureItemServiceRequest mixtureItemServiceRequest);
}
