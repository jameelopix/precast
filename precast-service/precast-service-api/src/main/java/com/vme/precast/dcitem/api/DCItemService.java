package com.vme.precast.dcitem.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface DCItemService extends BaseService {

 @FlowDescriptor(flow = "createdcitem", request = "dCItemServiceRequest", response = "dCItemServiceResponse")
 public DCItemServiceResponse createDCItem(DCItemServiceRequest dCItemServiceRequest);

 @FlowDescriptor(flow = "getdcitems", request = "dCItemServiceRequest", response = "dCItemServiceResponse")
 public DCItemServiceResponse getDCItems(DCItemServiceRequest dCItemServiceRequest);

 @FlowDescriptor(flow = "updatedcitem", request = "dCItemServiceRequest", response = "dCItemServiceResponse")
 public DCItemServiceResponse updateDCItem(DCItemServiceRequest dCItemServiceRequest);

 @FlowDescriptor(flow = "deletedcitem", request = "dCItemServiceRequest", response = "dCItemServiceResponse")
 public DCItemServiceResponse deleteDCItem(DCItemServiceRequest dCItemServiceRequest);
}