package com.vme.precast.mixtureitem.api;

import coliseum.service.ColiseumInterface;

public interface MixtureItemComponent extends ColiseumInterface {

 public MixtureItemServiceResponse createMixtureItem(MixtureItemServiceRequest mixtureItemServiceRequest);

 public MixtureItemServiceResponse getMixtureItems(MixtureItemServiceRequest mixtureItemServiceRequest);

 public MixtureItemServiceResponse updateMixtureItem(MixtureItemServiceRequest mixtureItemServiceRequest);

 public MixtureItemServiceResponse deleteMixtureItem(MixtureItemServiceRequest mixtureItemServiceRequest);
}
