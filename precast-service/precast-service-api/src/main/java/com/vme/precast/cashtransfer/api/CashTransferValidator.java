package com.vme.precast.cashtransfer.api;

import com.vme.precast.company.api.CompanyServiceRequest;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface CashTransferValidator extends ColiseumInterface {

	public ErrorDTO checkCashTransferDuplicate(CompanyServiceRequest companyServiceRequest);
}
