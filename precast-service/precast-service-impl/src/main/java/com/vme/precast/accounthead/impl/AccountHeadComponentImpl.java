package com.vme.precast.accounthead.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.accounthead.api.AccountHeadComponent;
import com.vme.precast.accounthead.api.AccountHeadDTO;
import com.vme.precast.accounthead.api.AccountHeadSearchDTO;
import com.vme.precast.accounthead.api.AccountHeadServiceRequest;
import com.vme.precast.accounthead.api.AccountHeadServiceResponse;
import com.vme.precast.domain.AccountHead;
import com.vme.precast.repository.AccountHeadRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class AccountHeadComponentImpl implements AccountHeadComponent {
    @Autowired
    AccountHeadRepo accountHeadRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public AccountHeadServiceResponse createAccountHead(AccountHeadServiceRequest accountHeadServiceRequest) {
        AccountHeadDTO accountHeadDTO = accountHeadServiceRequest.getAccountHeadDTO();
        AccountHead accounthead = (AccountHead) conversionUtility.convert(accountHeadDTO, AccountHeadDTO.class,
                AccountHead.class);
        accountHeadRepo.save(accounthead);
        return null;
    }

    @Override
    public AccountHeadServiceResponse getAccountHeads(AccountHeadServiceRequest accountHeadServiceRequest) {
        List<AccountHead> accountHeadList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        AccountHeadSearchDTO accountHeadSearchDTO = accountHeadServiceRequest.getAccountHeadSearchDTO();
        if (accountHeadSearchDTO != null) {
            List<Long> idList = accountHeadSearchDTO.getIdList();
            List<String> nameList = accountHeadSearchDTO.getNameList();

            FilterUtils.createEqualFilter(filters, AccountHeadSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, AccountHeadSearchDTO.NAME, nameList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(accountHeadServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(accountHeadServiceRequest.getRecordstoFetch());
        accountHeadList = accountHeadRepo.search(searchObject);

        List<AccountHeadDTO> accountHeadDTOList = new ArrayList<>();
        for (AccountHead target : accountHeadList) {
            accountHeadDTOList
                    .add((AccountHeadDTO) conversionUtility.convert(target, AccountHead.class, AccountHeadDTO.class));
        }
        AccountHeadServiceResponse accountHeadServiceResponse = new AccountHeadServiceResponse();
        accountHeadServiceResponse.setAccountHeadDTOList(accountHeadDTOList);
        return accountHeadServiceResponse;
    }

    @Override
    public AccountHeadServiceResponse updateAccountHead(AccountHeadServiceRequest accountHeadServiceRequest) {
        AccountHeadDTO source = accountHeadServiceRequest.getAccountHeadDTO();

        AccountHead target = accountHeadRepo.findById(source.getId()).get();
        target.setName(source.getName());

        accountHeadRepo.save(target);
        return null;
    }

    @Override
    public AccountHeadServiceResponse deleteAccountHead(AccountHeadServiceRequest accountHeadServiceRequest) {
        AccountHeadDTO accountHeadDTO = accountHeadServiceRequest.getAccountHeadDTO();
        accountHeadRepo.deleteById(accountHeadDTO.getId());
        return null;
    }
}