package com.vme.precast.subcontractor.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface SubContractorService extends BaseService {

	@FlowDescriptor(flow = "createSubContractor", request = "subContractorServiceRequest", response = "subContractorServiceResponse")
	public SubContractorServiceResponse createSubContractor(SubContractorServiceRequest subContractorServiceRequest);

	@FlowDescriptor(flow = "getSubContractors", request = "subContractorServiceRequest", response = "subContractorServiceResponse")
	public SubContractorServiceResponse getSubContractors(SubContractorServiceRequest subContractorServiceRequest);

	@FlowDescriptor(flow = "updateSubContractor", request = "subContractorServiceRequest", response = "subContractorServiceResponse")
	public SubContractorServiceResponse updateSubContractor(SubContractorServiceRequest subContractorServiceRequest);

	@FlowDescriptor(flow = "deleteSubContractor", request = "subContractorServiceRequest", response = "subContractorServiceResponse")
	public SubContractorServiceResponse deleteSubContractor(SubContractorServiceRequest subContractorServiceRequest);
}