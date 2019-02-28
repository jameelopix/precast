package com.vme.precast.company.api;

import coliseum.service.ColiseumValidator;
import coliseum.service.ErrorDTO;

public interface CompanyValidator extends ColiseumValidator {

	public ErrorDTO checkCompanyDuplicate(CompanyServiceRequest companyServiceRequest);
}
