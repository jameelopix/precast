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
import com.vme.precast.repository.AccountDetailsRepo;

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
        SearchObject searchObject = new SearchObject();

        AccountDetailsSearchDTO accountDetailsSearchDTO = accountDetailsServiceRequest.getAccountDetailsSearchDTO();
        if (accountDetailsSearchDTO != null) {
//            List<Long> ids = accountDetailsSearchDTO.getIds();
//            List<String> nameList = accountDetailsSearchDTO.getNameList();
//            List<Long> addressIdList = accountDetailsSearchDTO.getAddressIdList();

//            FilterUtils.createEqualFilter(filters, AccountDetailsSearchDTO.ID, ids);
//            FilterUtils.createEqualFilter(filters, AccountDetailsSearchDTO.NAME, nameList);
//            FilterUtils.createEqualFilter(filters, AccountDetailsSearchDTO.ADDRESS_ID, addressIdList);

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
//        target.setName(source.getName());

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