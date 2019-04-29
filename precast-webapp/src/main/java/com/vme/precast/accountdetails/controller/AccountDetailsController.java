package com.vme.precast.accountdetails.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.accountdetails.api.AccountDetailsDTO;
import com.vme.precast.accountdetails.api.AccountDetailsService;
import com.vme.precast.accountdetails.api.AccountDetailsServiceRequest;
import com.vme.precast.accountdetails.api.AccountDetailsServiceResponse;

@Controller
public class AccountDetailsController {

    @Autowired
    AccountDetailsService accountDetailsService;

    @RequestMapping(value = "deleteAccountDetails", method = RequestMethod.POST)
    @ResponseBody
    public AccountDetailsClientModel deleteAccountDetails(@RequestBody AccountDetailsClientModel accountDetailsClientModel) {
        AccountDetailsServiceRequest accountDetailsServiceRequest = new AccountDetailsServiceRequest();
        for (Long id : accountDetailsClientModel.getIdsToDelete()) {
            AccountDetailsDTO accountDetailsDTO = new AccountDetailsDTO();
            accountDetailsDTO.setId(id);
            accountDetailsServiceRequest.setAccountDetailsDTO(accountDetailsDTO);
            accountDetailsService.deleteAccountDetails(accountDetailsServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createAccountDetails", method = RequestMethod.POST)
    @ResponseBody
    public AccountDetailsClientModel createAccountDetails(@Valid @RequestBody AccountDetailsClientModel accountDetailsClientModel) {
        return this.constructClientModel(accountDetailsService.createAccountDetails(this.constructServiceRequest(accountDetailsClientModel)));
    }

    @RequestMapping(value = "updateAccountDetails", method = RequestMethod.POST)
    @ResponseBody
    public AccountDetailsClientModel updateAccountDetails(@Valid @RequestBody AccountDetailsClientModel accountDetailsClientModel) {
        return this.constructClientModel(accountDetailsService.updateAccountDetails(this.constructServiceRequest(accountDetailsClientModel)));
    }

    @RequestMapping(value = "getAccountDetails", method = RequestMethod.POST)
    @ResponseBody
    public AccountDetailsClientModel getAccountDetails(@RequestBody AccountDetailsClientModel accountDetailsClientModel) {
        return this.constructClientModel(accountDetailsService.getAccountDetailss(this.constructServiceRequest(accountDetailsClientModel)));
    }

    private AccountDetailsClientModel constructClientModel(AccountDetailsServiceResponse accountDetailsServiceResponse) {
        AccountDetailsClientModel accountDetailsClientModel = null;
        if (accountDetailsServiceResponse != null) {
            accountDetailsClientModel = new AccountDetailsClientModel();
            accountDetailsClientModel.setAccountDetailsDTOList(accountDetailsServiceResponse.getAccountDetailsDTOList());
            accountDetailsClientModel.setTotalRecords(accountDetailsServiceResponse.getTotalRecords());
        }
        return accountDetailsClientModel;
    }

    private AccountDetailsServiceRequest constructServiceRequest(AccountDetailsClientModel accountDetailsClientModel) {
        AccountDetailsServiceRequest accountDetailsServiceRequest = new AccountDetailsServiceRequest();
        accountDetailsServiceRequest.setAccountDetailsDTO(accountDetailsClientModel.getAccountDetailsDTO());
        accountDetailsServiceRequest.setAccountDetailsSearchDTO(accountDetailsClientModel.getAccountDetailsSearchDTO());
        accountDetailsServiceRequest.setRecordstoFetch(accountDetailsClientModel.getRecordstoFetch());
        accountDetailsServiceRequest.setPageIndex(accountDetailsClientModel.getPageIndex());
        return accountDetailsServiceRequest;
    }
}