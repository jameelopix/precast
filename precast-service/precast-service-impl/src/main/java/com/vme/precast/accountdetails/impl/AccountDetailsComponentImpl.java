package com.vme.precast.accountdetails.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.AccountDetails;
import com.vme.precast.repository.AccountDetailsRepo;
import com.vme.precast.accountdetails.api.AccountDetailsComponent;
import com.vme.precast.accountdetails.api.AccountDetailsDTO;
import com.vme.precast.accountdetails.api.AccountDetailsSearchDTO;
import com.vme.precast.accountdetails.api.AccountDetailsServiceRequest;
import com.vme.precast.accountdetails.api.AccountDetailsServiceResponse;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class AccountDetailsComponentImpl implements AccountDetailsComponent {
    @Autowired
    AccountDetailsRepo accountDetailsRepo;

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
        List<Association> associations = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        AccountDetailsSearchDTO accountDetailsSearchDTO = accountDetailsServiceRequest.getAccountDetailsSearchDTO();
        if (accountDetailsSearchDTO != null) {
            FilterUtils.createEqualFilter(filters, AccountDetailsSearchDTO.ID, accountDetailsSearchDTO.getIdList());
            FilterUtils.createEqualFilter(filters, AccountDetailsSearchDTO.ACCOUNTNAME,
                    accountDetailsSearchDTO.getAccountNameList());
            FilterUtils.createEqualFilter(filters, AccountDetailsSearchDTO.ACCOUNTNUMBER,
                    accountDetailsSearchDTO.getAccountNumberList());
            FilterUtils.createEqualFilter(filters, AccountDetailsSearchDTO.COMPANYID,
                    accountDetailsSearchDTO.getCompanyIdList());
            FilterUtils.createEqualFilter(filters, AccountDetailsSearchDTO.ACCOUNTTYPE,
                    accountDetailsSearchDTO.getAccountTypeList());

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }

            if (accountDetailsSearchDTO.getCompanyNeeded()) {
                Association purchaseOrderassociation = new Association();
                purchaseOrderassociation.setFieldName(AccountDetailsSearchDTO.COMPANY);
                associations.add(purchaseOrderassociation);
            }

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
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
        target.setCompanyId(source.getCompanyId());

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