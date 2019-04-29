package com.vme.precast.dcregister.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface DCRegisterService extends BaseService {

 @FlowDescriptor(flow = "createdcregister", request = "dCRegisterServiceRequest", response = "dCRegisterServiceResponse")
 public DCRegisterServiceResponse createDCRegister(DCRegisterServiceRequest dCRegisterServiceRequest);

 @FlowDescriptor(flow = "getdcregisters", request = "dCRegisterServiceRequest", response = "dCRegisterServiceResponse")
 public DCRegisterServiceResponse getDCRegisters(DCRegisterServiceRequest dCRegisterServiceRequest);

 @FlowDescriptor(flow = "updatedcregister", request = "dCRegisterServiceRequest", response = "dCRegisterServiceResponse")
 public DCRegisterServiceResponse updateDCRegister(DCRegisterServiceRequest dCRegisterServiceRequest);

 @FlowDescriptor(flow = "deletedcregister", request = "dCRegisterServiceRequest", response = "dCRegisterServiceResponse")
 public DCRegisterServiceResponse deleteDCRegister(DCRegisterServiceRequest dCRegisterServiceRequest);
}