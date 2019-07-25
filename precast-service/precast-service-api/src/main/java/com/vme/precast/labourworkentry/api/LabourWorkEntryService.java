package com.vme.precast.labourworkentry.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface LabourWorkEntryService extends BaseService {

 @FlowDescriptor(flow = "createlabourworkentry", request = "labourWorkEntryServiceRequest", response = "labourWorkEntryServiceResponse")
 public LabourWorkEntryServiceResponse createLabourWorkEntry(LabourWorkEntryServiceRequest labourWorkEntryServiceRequest);

 @FlowDescriptor(flow = "getlabourworkentrys", request = "labourWorkEntryServiceRequest", response = "labourWorkEntryServiceResponse")
 public LabourWorkEntryServiceResponse getLabourWorkEntrys(LabourWorkEntryServiceRequest labourWorkEntryServiceRequest);

 @FlowDescriptor(flow = "updatelabourworkentry", request = "labourWorkEntryServiceRequest", response = "labourWorkEntryServiceResponse")
 public LabourWorkEntryServiceResponse updateLabourWorkEntry(LabourWorkEntryServiceRequest labourWorkEntryServiceRequest);

 @FlowDescriptor(flow = "deletelabourworkentry", request = "labourWorkEntryServiceRequest", response = "labourWorkEntryServiceResponse")
 public LabourWorkEntryServiceResponse deleteLabourWorkEntry(LabourWorkEntryServiceRequest labourWorkEntryServiceRequest);
}