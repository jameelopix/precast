package com.vme.precast.subcontractor.api;

import coliseum.service.ColiseumInterface;

public interface SubContractorComponent extends ColiseumInterface {

    public SubContractorServiceResponse createSubContractor(SubContractorServiceRequest subContractorServiceRequest);

    public SubContractorServiceResponse getSubContractors(SubContractorServiceRequest subContractorServiceRequest);

    public SubContractorServiceResponse updateSubContractor(SubContractorServiceRequest subContractorServiceRequest);

    public SubContractorServiceResponse deleteSubContractor(SubContractorServiceRequest subContractorServiceRequest);

//    public void createAddress(SubContractorServiceRequest subContractorServiceRequest);
//
//    public void createFinancialDetail(SubContractorServiceRequest subContractorServiceRequest);
}
