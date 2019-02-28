package com.vme.precast.cashtransfer.impl;

import com.vme.precast.cashtransfer.api.CashTransferValidator;
import com.vme.precast.company.api.CompanyServiceRequest;

import coliseum.service.ErrorDTO;

public class CashTransferValidatorImpl implements CashTransferValidator {

	@Override
	public ErrorDTO checkCashTransferDuplicate(CompanyServiceRequest companyServiceRequest) {
		System.out.println("CashTransferValidatorImpl.checkCashTransferDuplicate()");
		return null;
	}
}