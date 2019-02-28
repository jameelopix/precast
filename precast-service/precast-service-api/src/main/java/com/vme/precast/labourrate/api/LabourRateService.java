package com.vme.precast.labourrate.api;

public interface LabourRateService {

	public LabourRateServiceResponse createLabourRate(LabourRateServiceRequest serviceRequest);

	public LabourRateServiceResponse getLabourRates(LabourRateServiceRequest serviceRequest);

	public LabourRateServiceResponse updateLabourRate(LabourRateServiceRequest serviceRequest);

	public LabourRateServiceResponse deleteLabourRate(LabourRateServiceRequest serviceRequest);
}
