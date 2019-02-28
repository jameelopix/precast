package com.vme.precast.bankaccount.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class BankAccountSearchDTO extends BaseSearchDTO {

	private static final long serialVersionUID = 1L;

	private List<String> accountNos;

	private List<Boolean> defaultAccounts;

	private List<Boolean> disableds;

	private List<Long> companyIds;

	public List<String> getAccountNos() {
		return accountNos;
	}

	public List<Boolean> getDefaultAccounts() {
		return defaultAccounts;
	}

	public List<Boolean> getDisableds() {
		return disableds;
	}

	public List<Long> getCompanyIds() {
		return companyIds;
	}

	public void setAccountNos(List<String> accountNos) {
		this.accountNos = accountNos;
	}

	public void setDefaultAccounts(List<Boolean> defaultAccounts) {
		this.defaultAccounts = defaultAccounts;
	}

	public void setDisableds(List<Boolean> disableds) {
		this.disableds = disableds;
	}

	public void setCompanyIds(List<Long> companyIds) {
		this.companyIds = companyIds;
	}
}
