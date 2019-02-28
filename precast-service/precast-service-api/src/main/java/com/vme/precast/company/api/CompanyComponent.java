package com.vme.precast.company.api;

import coliseum.service.ColiseumComponent;

public interface CompanyComponent extends ColiseumComponent {

	public CompanyServiceResponse createCompany(CompanyServiceRequest companyServiceRequest);

	public CompanyServiceResponse getCompanys(CompanyServiceRequest companyServiceRequest);

	public CompanyServiceResponse updateCompany(CompanyServiceRequest companyServiceRequest);

	public CompanyServiceResponse deleteCompany(CompanyServiceRequest companyServiceRequest);
}
