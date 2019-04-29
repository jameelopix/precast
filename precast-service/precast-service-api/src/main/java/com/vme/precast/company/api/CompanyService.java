package com.vme.precast.company.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface CompanyService extends BaseService {

 @FlowDescriptor(flow = "createcompany", request = "companyServiceRequest", response = "companyServiceResponse")
 public CompanyServiceResponse createCompany(CompanyServiceRequest companyServiceRequest);

 @FlowDescriptor(flow = "getcompanys", request = "companyServiceRequest", response = "companyServiceResponse")
 public CompanyServiceResponse getCompanys(CompanyServiceRequest companyServiceRequest);

 @FlowDescriptor(flow = "updatecompany", request = "companyServiceRequest", response = "companyServiceResponse")
 public CompanyServiceResponse updateCompany(CompanyServiceRequest companyServiceRequest);

 @FlowDescriptor(flow = "deletecompany", request = "companyServiceRequest", response = "companyServiceResponse")
 public CompanyServiceResponse deleteCompany(CompanyServiceRequest companyServiceRequest);
}