package com.vme.precast.workdetail.api;

import coliseum.service.ColiseumInterface;

public interface WorkDetailComponent extends ColiseumInterface {

	public WorkDetailServiceResponse createWorkDetail(WorkDetailServiceRequest workDetailServiceRequest);

	public WorkDetailServiceResponse getWorkDetails(WorkDetailServiceRequest workDetailServiceRequest);

	public WorkDetailServiceResponse updateWorkDetail(WorkDetailServiceRequest workDetailServiceRequest);

	public WorkDetailServiceResponse deleteWorkDetail(WorkDetailServiceRequest workDetailServiceRequest);
}