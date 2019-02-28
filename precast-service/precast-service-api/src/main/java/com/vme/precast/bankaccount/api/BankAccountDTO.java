package com.vme.precast.bankaccount.api;

import com.vme.precast.company.api.CompanyDTO;

import coliseum.service.BaseDTO;

public class BankAccountDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String accountNo;

	private Boolean defaultAccount;

	private Boolean disabled;

	private Long companyId;

	private CompanyDTO companyDTO;

	public static String ID = "id";
	public static String ACCOUNT_NO = "accountNo";
	public static String DEF_ACCOUNT = "defaultAccount";
	public static String DISABLED = "disabled";

	public Long getId() {
		return id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Boolean getDefaultAccount() {
		return defaultAccount;
	}

	public void setDefaultAccount(Boolean defaultAccount) {
		this.defaultAccount = defaultAccount;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}

	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}
}