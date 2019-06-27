package com.vme.precast.mixture.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface MixtureValidator extends ColiseumInterface {

 public ErrorDTO checkMixtureDuplicate(MixtureServiceRequest mixtureServiceRequest);
}
