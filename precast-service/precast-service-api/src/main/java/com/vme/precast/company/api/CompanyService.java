package com.vme.precast.company.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface CompanyService extends BaseService {

	@FlowDescriptor(flow = "createCompany", request = "companyServiceRequest", response = "companyServiceResponse")
	public CompanyServiceResponse createCompany(CompanyServiceRequest companyServiceRequest);

	@FlowDescriptor(flow = "getCompanys", request = "companyServiceRequest", response = "companyServiceResponse")
	public CompanyServiceResponse getCompanys(CompanyServiceRequest companyServiceRequest);

	@FlowDescriptor(flow = "updateCompany", request = "companyServiceRequest", response = "companyServiceResponse")
	public CompanyServiceResponse updateCompany(CompanyServiceRequest companyServiceRequest);

	@FlowDescriptor(flow = "deleteCompany", request = "companyServiceRequest", response = "companyServiceResponse")
	public CompanyServiceResponse deleteCompany(CompanyServiceRequest companyServiceRequest);
}