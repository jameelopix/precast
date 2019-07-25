package com.vme.precast.financialdetail.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface FinancialDetailService extends BaseService {

 @FlowDescriptor(flow = "createfinancialdetail", request = "financialDetailServiceRequest", response = "financialDetailServiceResponse")
 public FinancialDetailServiceResponse createFinancialDetail(FinancialDetailServiceRequest financialDetailServiceRequest);

 @FlowDescriptor(flow = "getfinancialdetails", request = "financialDetailServiceRequest", response = "financialDetailServiceResponse")
 public FinancialDetailServiceResponse getFinancialDetails(FinancialDetailServiceRequest financialDetailServiceRequest);

 @FlowDescriptor(flow = "updatefinancialdetail", request = "financialDetailServiceRequest", response = "financialDetailServiceResponse")
 public FinancialDetailServiceResponse updateFinancialDetail(FinancialDetailServiceRequest financialDetailServiceRequest);

 @FlowDescriptor(flow = "deletefinancialdetail", request = "financialDetailServiceRequest", response = "financialDetailServiceResponse")
 public FinancialDetailServiceResponse deleteFinancialDetail(FinancialDetailServiceRequest financialDetailServiceRequest);
}