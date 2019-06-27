package com.vme.precast.mixtureitem.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface MixtureItemService extends BaseService {

 @FlowDescriptor(flow = "createmixtureitem", request = "mixtureItemServiceRequest", response = "mixtureItemServiceResponse")
 public MixtureItemServiceResponse createMixtureItem(MixtureItemServiceRequest mixtureItemServiceRequest);

 @FlowDescriptor(flow = "getmixtureitems", request = "mixtureItemServiceRequest", response = "mixtureItemServiceResponse")
 public MixtureItemServiceResponse getMixtureItems(MixtureItemServiceRequest mixtureItemServiceRequest);

 @FlowDescriptor(flow = "updatemixtureitem", request = "mixtureItemServiceRequest", response = "mixtureItemServiceResponse")
 public MixtureItemServiceResponse updateMixtureItem(MixtureItemServiceRequest mixtureItemServiceRequest);

 @FlowDescriptor(flow = "deletemixtureitem", request = "mixtureItemServiceRequest", response = "mixtureItemServiceResponse")
 public MixtureItemServiceResponse deleteMixtureItem(MixtureItemServiceRequest mixtureItemServiceRequest);
}