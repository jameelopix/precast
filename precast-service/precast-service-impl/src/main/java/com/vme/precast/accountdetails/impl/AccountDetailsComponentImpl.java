package com.vme.precast.accountdetails.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.accountdetails.api.AccountDetailsComponent;
import com.vme.precast.accountdetails.api.AccountDetailsDTO;
import com.vme.precast.accountdetails.api.AccountDetailsSearchDTO;
import com.vme.precast.accountdetails.api.AccountDetailsServiceRequest;
import com.vme.precast.accountdetails.api.AccountDetailsServiceResponse;
import com.vme.precast.domain.AccountDetails;
import com.vme.precast.domain.Company;
import com.vme.precast.repository.AccountDetailsRepo;
import com.vme.precast.repository.CompanyRepo;
import com.vme.precast.shared.AccountType;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class AccountDetailsComponentImpl implements AccountDetailsComponent {
    @Autowired
    AccountDetailsRepo accountDetailsRepo;

    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public AccountDetailsServiceResponse createAccountDetails(
            AccountDetailsServiceRequest accountDetailsServiceRequest) {
        AccountDetailsDTO accountDetailsDTO = accountDetailsServiceRequest.getAccountDetailsDTO();
        AccountDetails accountdetails = (AccountDetails) conversionUtility.convert(accountDetailsDTO,
                AccountDetailsDTO.class, AccountDetails.class);
        accountDetailsRepo.save(accountdetails);
        return null;
    }

    @Override
    public AccountDetailsServiceResponse getAccountDetailss(AccountDetailsServiceRequest accountDetailsServiceRequest) {
        List<AccountDetails> accountDetailsList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        AccountDetailsSearchDTO accountDetailsSearchDTO = accountDetailsServiceRequest.getAccountDetailsSearchDTO();
        if (accountDetailsSearchDTO != null) {
            List<Long> idList = accountDetailsSearchDTO.getIdList();
            List<String> accountNameList = accountDetailsSearchDTO.getAccountNameList();
            List<String> accountNumberList = accountDetailsSearchDTO.getAccountNumberList();
            List<AccountType> accountTypeList = accountDetailsSearchDTO.getAccountTypeList();
            List<Long> companyIdList = accountDetailsSearchDTO.getCompanyIdList();

            FilterUtils.createEqualFilter(filters, AccountDetailsSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, AccountDetailsSearchDTO.ACCOUNTNAME, accountNameList);
            FilterUtils.createEqualFilter(filters, AccountDetailsSearchDTO.ACCOUNTNUMBER, accountNumberList);
            FilterUtils.createEqualFilter(filters, AccountDetailsSearchDTO.ACCOUNTTYPE, accountTypeList);
            FilterUtils.createEqualFilter(filters, AccountDetailsSearchDTO.COMPANYID, companyIdList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(accountDetailsServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(accountDetailsServiceRequest.getRecordstoFetch());
        accountDetailsList = accountDetailsRepo.search(searchObject);

        List<AccountDetailsDTO> accountDetailsDTOList = new ArrayList<>();
        for (AccountDetails target : accountDetailsList) {
            accountDetailsDTOList.add((AccountDetailsDTO) conversionUtility.convert(target, AccountDetails.class,
                    AccountDetailsDTO.class));
        }
        AccountDetailsServiceResponse accountDetailsServiceResponse = new AccountDetailsServiceResponse();
        accountDetailsServiceResponse.setAccountDetailsDTOList(accountDetailsDTOList);
        return accountDetailsServiceResponse;
    }

    @Override
    public AccountDetailsServiceResponse updateAccountDetails(
            AccountDetailsServiceRequest accountDetailsServiceRequest) {
        AccountDetailsDTO source = accountDetailsServiceRequest.getAccountDetailsDTO();

        AccountDetails target = accountDetailsRepo.findById(source.getId()).get();
        target.setAccountName(source.getAccountName());
        target.setAccountNumber(source.getAccountNumber());
        target.setAccountType(source.getAccountType());

        if (source.getCompanyId() != null && !source.getCompanyId().equals(target.getCompanyId())) {
            Company company = companyRepo.findById(source.getCompanyId()).get();
            target.setCompany(company);
        }
        accountDetailsRepo.save(target);
        return null;
    }

    @Override
    public AccountDetailsServiceResponse deleteAccountDetails(
            AccountDetailsServiceRequest accountDetailsServiceRequest) {
        AccountDetailsDTO accountDetailsDTO = accountDetailsServiceRequest.getAccountDetailsDTO();
        accountDetailsRepo.deleteById(accountDetailsDTO.getId());
        return null;
    }
}