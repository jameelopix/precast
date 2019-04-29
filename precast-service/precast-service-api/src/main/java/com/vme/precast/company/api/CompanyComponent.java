package com.vme.precast.company.api;

import coliseum.service.ColiseumInterface;

public interface CompanyComponent extends ColiseumInterface {

 public CompanyServiceResponse createCompany(CompanyServiceRequest companyServiceRequest);

 public CompanyServiceResponse getCompanys(CompanyServiceRequest companyServiceRequest);

 public CompanyServiceResponse updateCompany(CompanyServiceRequest companyServiceRequest);

 public CompanyServiceResponse deleteCompany(CompanyServiceRequest companyServiceRequest);
}
