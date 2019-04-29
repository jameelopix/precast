package com.vme.precast.company.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface CompanyValidator extends ColiseumInterface {

 public ErrorDTO checkCompanyDuplicate(CompanyServiceRequest companyServiceRequest);
}
