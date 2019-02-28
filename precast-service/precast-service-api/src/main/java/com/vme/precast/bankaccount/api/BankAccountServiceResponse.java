package com.vme.precast.bankaccount.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class BankAccountServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<BankAccountDTO> bankAccountDTOs;

	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}

	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTOs) {
		this.bankAccountDTOs = bankAccountDTOs;
	}
}