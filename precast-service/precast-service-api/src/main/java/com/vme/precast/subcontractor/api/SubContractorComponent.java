package com.vme.precast.subcontractor.api;

import coliseum.service.ColiseumInterface;

public interface SubContractorComponent extends ColiseumInterface {

	public SubContractorServiceResponse createSubContractor(SubContractorServiceRequest serviceRequest);

	public SubContractorServiceResponse getSubContractors(SubContractorServiceRequest serviceRequest);

	public SubContractorServiceResponse updateSubContractor(SubContractorServiceRequest serviceRequest);

	public SubContractorServiceResponse deleteSubContractor(SubContractorServiceRequest serviceRequest);
}
