package com.vme.precast.labourrate.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface LabourRateService extends BaseService {

 @FlowDescriptor(flow = "createlabourrate", request = "labourRateServiceRequest", response = "labourRateServiceResponse")
 public LabourRateServiceResponse createLabourRate(LabourRateServiceRequest labourRateServiceRequest);

 @FlowDescriptor(flow = "getlabourrates", request = "labourRateServiceRequest", response = "labourRateServiceResponse")
 public LabourRateServiceResponse getLabourRates(LabourRateServiceRequest labourRateServiceRequest);

 @FlowDescriptor(flow = "updatelabourrate", request = "labourRateServiceRequest", response = "labourRateServiceResponse")
 public LabourRateServiceResponse updateLabourRate(LabourRateServiceRequest labourRateServiceRequest);

 @FlowDescriptor(flow = "deletelabourrate", request = "labourRateServiceRequest", response = "labourRateServiceResponse")
 public LabourRateServiceResponse deleteLabourRate(LabourRateServiceRequest labourRateServiceRequest);
}