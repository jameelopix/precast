package com.vme.precast.subcontractor.api;

import com.vme.precast.address.api.AddressServiceRequest;
import com.vme.precast.address.api.AddressServiceResponse;
import com.vme.precast.financialdetail.api.FinancialDetailServiceRequest;
import com.vme.precast.financialdetail.api.FinancialDetailServiceResponse;

import coliseum.service.ColiseumInterface;

public interface SubContractorComponent extends ColiseumInterface {

    public SubContractorServiceResponse createSubContractor(SubContractorServiceRequest subContractorServiceRequest);

    public SubContractorServiceResponse getSubContractors(SubContractorServiceRequest subContractorServiceRequest);

    public SubContractorServiceResponse updateSubContractor(SubContractorServiceRequest subContractorServiceRequest);

    public SubContractorServiceResponse deleteSubContractor(SubContractorServiceRequest subContractorServiceRequest);

    public AddressServiceRequest createAddressServiceRequest(SubContractorServiceRequest subContractorServiceRequest);

    public FinancialDetailServiceRequest createFinancialDetailServiceRequest(
            SubContractorServiceRequest subContractorServiceRequest);

    public void updateSubContractorServiceRequest(SubContractorServiceRequest subContractorServiceRequest,
            AddressServiceResponse addressServiceResponse,
            FinancialDetailServiceResponse financialDetailServiceResponse);
}
