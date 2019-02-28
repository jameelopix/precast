package com.vme.precast.bankaccount.controller;

import java.util.List;

import com.vme.precast.bankaccount.api.BankAccountDTO;
import com.vme.precast.bankaccount.api.BankAccountSearchDTO;

import coliseum.web.BaseWidgetModel;

public class BankAccountWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	private BankAccountDTO bankAccountDTO;

	private BankAccountSearchDTO bankAccountSearchDTO;

	private List<BankAccountDTO> bankAccountDTOs;

	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}

	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTOs) {
		this.bankAccountDTOs = bankAccountDTOs;
	}

	public BankAccountDTO getBankAccountDTO() {
		return bankAccountDTO;
	}

	public void setBankAccountDTO(BankAccountDTO bankAccountDTO) {
		this.bankAccountDTO = bankAccountDTO;
	}

	public BankAccountSearchDTO getBankAccountSearchDTO() {
		return bankAccountSearchDTO;
	}

	public void setBankAccountSearchDTO(BankAccountSearchDTO bankAccountSearchDTO) {
		this.bankAccountSearchDTO = bankAccountSearchDTO;
	}
}
