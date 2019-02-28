package com.vme.precast.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class Company extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private Boolean selfCompany;

	private Boolean disabled;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private List<BankAccount> bankAccounts;

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

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
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

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
}