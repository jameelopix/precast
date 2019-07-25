package com.vme.precast.subcontractor.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface SubContractorService extends BaseService {

 @FlowDescriptor(flow = "createsubcontractor", request = "subContractorServiceRequest", response = "subContractorServiceResponse")
 public SubContractorServiceResponse createSubContractor(SubContractorServiceRequest subContractorServiceRequest);

 @FlowDescriptor(flow = "getsubcontractors", request = "subContractorServiceRequest", response = "subContractorServiceResponse")
 public SubContractorServiceResponse getSubContractors(SubContractorServiceRequest subContractorServiceRequest);

 @FlowDescriptor(flow = "updatesubcontractor", request = "subContractorServiceRequest", response = "subContractorServiceResponse")
 public SubContractorServiceResponse updateSubContractor(SubContractorServiceRequest subContractorServiceRequest);

 @FlowDescriptor(flow = "deletesubcontractor", request = "subContractorServiceRequest", response = "subContractorServiceResponse")
 public SubContractorServiceResponse deleteSubContractor(SubContractorServiceRequest subContractorServiceRequest);
}