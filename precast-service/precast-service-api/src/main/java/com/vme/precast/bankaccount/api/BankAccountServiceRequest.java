package com.vme.precast.bankaccount.api;

import coliseum.service.BaseServiceRequest;

public class BankAccountServiceRequest extends BaseServiceRequest {

	private static final long serialVersionUID = 1L;

	private BankAccountDTO bankAccountDTO;

	private BankAccountSearchDTO bankAccountSearchDTO;

	public BankAccountSearchDTO getBankAccountSearchDTO() {
		return bankAccountSearchDTO;
	}

	public void setBankAccountSearchDTO(BankAccountSearchDTO bankAccountSearchDTO) {
		this.bankAccountSearchDTO = bankAccountSearchDTO;
	}

	public BankAccountDTO getBankAccountDTO() {
		return bankAccountDTO;
	}

	public void setBankAccountDTO(BankAccountDTO bankAccountDTO) {
		this.bankAccountDTO = bankAccountDTO;
	}
}
