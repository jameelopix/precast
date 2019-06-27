package com.vme.precast.mixture.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface MixtureService extends BaseService {

 @FlowDescriptor(flow = "createmixture", request = "mixtureServiceRequest", response = "mixtureServiceResponse")
 public MixtureServiceResponse createMixture(MixtureServiceRequest mixtureServiceRequest);

 @FlowDescriptor(flow = "getmixtures", request = "mixtureServiceRequest", response = "mixtureServiceResponse")
 public MixtureServiceResponse getMixtures(MixtureServiceRequest mixtureServiceRequest);

 @FlowDescriptor(flow = "updatemixture", request = "mixtureServiceRequest", response = "mixtureServiceResponse")
 public MixtureServiceResponse updateMixture(MixtureServiceRequest mixtureServiceRequest);

 @FlowDescriptor(flow = "deletemixture", request = "mixtureServiceRequest", response = "mixtureServiceResponse")
 public MixtureServiceResponse deleteMixture(MixtureServiceRequest mixtureServiceRequest);
}