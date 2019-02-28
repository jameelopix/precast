package com.vme.precast.bankaccount.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.bankaccount.api.BankAccountDTO;
import com.vme.precast.bankaccount.api.BankAccountServiceRequest;
import com.vme.precast.bankaccount.api.BankAccountValidator;
import com.vme.precast.domain.BankAccount;
import com.vme.precast.repository.BankAccountRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ErrorDTO;

public class BankAccountValidatorImpl implements BankAccountValidator {

	@Autowired
	private BankAccountRepo bankAccountRepo;

	@Override
	public ErrorDTO checkBankAccountDuplicate(BankAccountServiceRequest bankAccountServiceRequest) {
		ErrorDTO errorDTO = null;
		BankAccountDTO bankAccountDTO = bankAccountServiceRequest.getBankAccountDTO();

		SearchObject searchObject = new SearchObject();
		List<Filter> filters = new ArrayList<>();
		createEqualFilter(filters, BankAccountDTO.ACCOUNT_NO, bankAccountDTO.getAccountNo());
		createEqualFilter(filters, BankAccountDTO.DISABLED, false);
		if (CollectionUtils.isNotEmpty(filters)) {
			searchObject.setFilters(filters);
		}
		List<BankAccount> companies = bankAccountRepo.search(searchObject);

		if (CollectionUtils.isNotEmpty(companies)) {
			for (BankAccount company : companies) {
				if (!company.getId().equals(bankAccountDTO.getId())) {
					errorDTO = new ErrorDTO("ERR110", "BankAccount already exists!!!");
					break;
				}
			}
		}
		return errorDTO;
	}
}