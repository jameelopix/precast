package com.vme.precast.subcontractor.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface SubContractorValidator extends ColiseumInterface {

	public ErrorDTO checkSubContractorDuplicate(SubContractorServiceRequest subContractorServiceRequest);
}
