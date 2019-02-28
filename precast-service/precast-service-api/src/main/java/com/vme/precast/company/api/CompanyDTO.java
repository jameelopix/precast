package com.vme.precast.company.api;

import java.util.List;

import com.vme.precast.bankaccount.api.BankAccountDTO;

import coliseum.service.BaseDTO;

public class CompanyDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private Boolean selfCompany;

	private Boolean disabled;

	private List<Long> bankAccountIds;

	private List<BankAccountDTO> bankAccountDTOs;

	public static String ID = "id";
	public static String NAME = "name";
	public static String SELF_COMPANY = "selfCompany";
	public static String DISABLED = "disabled";

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Boolean getSelfCompany() {
		return selfCompany;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSelfCompany(Boolean selfCompany) {
		this.selfCompany = selfCompany;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTOs) {
		this.bankAccountDTOs = bankAccountDTOs;
	}

	public List<Long> getBankAccountIds() {
		return bankAccountIds;
	}

	public void setBankAccountIds(List<Long> bankAccountIds) {
		this.bankAccountIds = bankAccountIds;
	}
}
