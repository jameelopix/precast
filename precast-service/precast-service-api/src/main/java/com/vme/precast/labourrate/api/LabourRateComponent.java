package com.vme.precast.labourrate.api;

import coliseum.service.ColiseumInterface;

public interface LabourRateComponent extends ColiseumInterface {

 public LabourRateServiceResponse createLabourRate(LabourRateServiceRequest labourRateServiceRequest);

 public LabourRateServiceResponse getLabourRates(LabourRateServiceRequest labourRateServiceRequest);

 public LabourRateServiceResponse updateLabourRate(LabourRateServiceRequest labourRateServiceRequest);

 public LabourRateServiceResponse deleteLabourRate(LabourRateServiceRequest labourRateServiceRequest);
}
