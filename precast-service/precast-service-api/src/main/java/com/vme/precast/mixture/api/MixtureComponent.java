package com.vme.precast.mixture.api;

import coliseum.service.ColiseumInterface;

public interface MixtureComponent extends ColiseumInterface {

 public MixtureServiceResponse createMixture(MixtureServiceRequest mixtureServiceRequest);

 public MixtureServiceResponse getMixtures(MixtureServiceRequest mixtureServiceRequest);

 public MixtureServiceResponse updateMixture(MixtureServiceRequest mixtureServiceRequest);

 public MixtureServiceResponse deleteMixture(MixtureServiceRequest mixtureServiceRequest);
}
