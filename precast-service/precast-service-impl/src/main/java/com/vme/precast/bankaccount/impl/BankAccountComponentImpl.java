package com.vme.precast.bankaccount.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.bankaccount.api.BankAccountComponent;
import com.vme.precast.bankaccount.api.BankAccountDTO;
import com.vme.precast.bankaccount.api.BankAccountSearchDTO;
import com.vme.precast.bankaccount.api.BankAccountServiceRequest;
import com.vme.precast.bankaccount.api.BankAccountServiceResponse;
import com.vme.precast.company.api.CompanyDTO;
import com.vme.precast.domain.BankAccount;
import com.vme.precast.domain.Company;
import com.vme.precast.repository.BankAccountRepo;
import com.vme.precast.repository.CompanyRepo;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;

public class BankAccountComponentImpl implements BankAccountComponent {

	@Autowired
	private BankAccountRepo bankAccountRepo;

	@Autowired
	private CompanyRepo companyRepo;

	@Autowired
	private ConversionService conversionService;

	@Override
	public BankAccountServiceResponse createBankAccount(BankAccountServiceRequest bankAccountServiceRequest) {
		BankAccountDTO bankAccountDTO = bankAccountServiceRequest.getBankAccountDTO();
		BankAccount bankAccount = conversionService.convert(bankAccountDTO, BankAccount.class);
		bankAccount.setDefaultAccount(false);
		bankAccount.setDisabled(false);

		Company company = companyRepo.findById(bankAccountDTO.getCompanyId()).get();
		bankAccount.setCompany(company);
		bankAccountRepo.save(bankAccount);
		return new BankAccountServiceResponse();
	}

	@Override
	public BankAccountServiceResponse getBankAccounts(BankAccountServiceRequest bankAccountServiceRequest) {
		List<BankAccount> companies = new ArrayList<>();
		List<Filter> filters = new ArrayList<>();
		SearchObject searchObject = new SearchObject();

		BankAccountSearchDTO searchDTO = bankAccountServiceRequest.getBankAccountSearchDTO();
		if (searchDTO != null) {
			List<Long> ids = searchDTO.getIds();
			List<String> accountNos = searchDTO.getAccountNos();
			List<Boolean> defaultAccounts = searchDTO.getDefaultAccounts();
			createEqualFilter(filters, BankAccountDTO.ID, ids);
			createEqualFilter(filters, BankAccountDTO.ACCOUNT_NO, accountNos);
			createEqualFilter(filters, BankAccountDTO.DEF_ACCOUNT, defaultAccounts);

			// Remove disabled companies
			createEqualFilter(filters, BankAccountDTO.DISABLED, false);

			if (CollectionUtils.isNotEmpty(filters)) {
				searchObject.setFilters(filters);
			}
		}

		Association association = new Association();
		association.setFieldName("company");
		association.setChildless(true);

		searchObject.setAssociations(Arrays.asList(association));
		searchObject.setPageIndex(bankAccountServiceRequest.getPageIndex());
		searchObject.setRecordstoFetch(bankAccountServiceRequest.getRecordstoFetch());
		companies = bankAccountRepo.search(searchObject);

		List<BankAccountDTO> bankAccountDTOs = new ArrayList<>();
		for (BankAccount target : companies) {
			BankAccountDTO bankAccountDTO = conversionService.convert(target, BankAccountDTO.class);

			if (target.getCompany() != null && target.getCompany() instanceof Company) {
				CompanyDTO companyDTO = this.conversionService.convert(target.getCompany(), CompanyDTO.class);
				bankAccountDTO.setCompanyDTO(companyDTO);
			}

			bankAccountDTOs.add(bankAccountDTO);
		}
		BankAccountServiceResponse bankAccountServiceResponse = new BankAccountServiceResponse();
		bankAccountServiceResponse.setBankAccountDTOs(bankAccountDTOs);
		return bankAccountServiceResponse;
	}

	@Override
	public BankAccountServiceResponse updateBankAccount(BankAccountServiceRequest bankAccountServiceRequest) {
		BankAccountDTO source = bankAccountServiceRequest.getBankAccountDTO();

		BankAccount target = bankAccountRepo.findById(source.getId()).get();
		if (!target.getCompanyId().equals(source.getCompanyId())) {
			Company company = companyRepo.findById(source.getCompanyId()).get();
			target.setCompany(company);
		}

		target.setAccountNo(source.getAccountNo());
		bankAccountRepo.save(target);

		return new BankAccountServiceResponse();
	}

	@Override
	public BankAccountServiceResponse deleteBankAccount(BankAccountServiceRequest bankAccountServiceRequest) {
		BankAccountDTO source = bankAccountServiceRequest.getBankAccountDTO();

		BankAccount target = bankAccountRepo.findById(source.getId()).get();
		target.setDisabled(true);
		bankAccountRepo.save(target);

		return new BankAccountServiceResponse();
	}

	@Override
	public BankAccountServiceResponse setDefaultBankAccount(BankAccountServiceRequest bankAccountServiceRequest) {
		BankAccountDTO source = bankAccountServiceRequest.getBankAccountDTO();

		BankAccount target = bankAccountRepo.findById(source.getId()).get();
		target.setDefaultAccount(true);
		bankAccountRepo.save(target);

		return new BankAccountServiceResponse();
	}
}