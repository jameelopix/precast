package com.vme.precast.workdetail.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface WorkDetailService extends BaseService {

	@FlowDescriptor(flow = "createWorkDetail", request = "workDetailServiceRequest", response = "workDetailServiceResponse")
	public WorkDetailServiceResponse createWorkDetail(WorkDetailServiceRequest workDetailServiceRequest);

	@FlowDescriptor(flow = "getWorkDetails", request = "workDetailServiceRequest", response = "workDetailServiceResponse")
	public WorkDetailServiceResponse getWorkDetails(WorkDetailServiceRequest workDetailServiceRequest);

	@FlowDescriptor(flow = "updateWorkDetail", request = "workDetailServiceRequest", response = "workDetailServiceResponse")
	public WorkDetailServiceResponse updateWorkDetail(WorkDetailServiceRequest workDetailServiceRequest);

	@FlowDescriptor(flow = "deleteWorkDetail", request = "workDetailServiceRequest", response = "workDetailServiceResponse")
	public WorkDetailServiceResponse deleteWorkDetail(WorkDetailServiceRequest workDetailServiceRequest);
}