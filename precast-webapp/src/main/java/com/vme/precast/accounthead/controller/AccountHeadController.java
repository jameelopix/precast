package com.vme.precast.accounthead.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.accounthead.api.AccountHeadDTO;
import com.vme.precast.accounthead.api.AccountHeadService;
import com.vme.precast.accounthead.api.AccountHeadServiceRequest;
import com.vme.precast.accounthead.api.AccountHeadServiceResponse;

@Controller
public class AccountHeadController {

    @Autowired
    AccountHeadService accountHeadService;

    @RequestMapping(value = "deleteAccountHead", method = RequestMethod.POST)
    @ResponseBody
    public AccountHeadClientModel deleteAccountHead(@RequestBody AccountHeadClientModel accountHeadClientModel) {
        AccountHeadServiceRequest accountHeadServiceRequest = new AccountHeadServiceRequest();
        for (Long id : accountHeadClientModel.getIdsToDelete()) {
            AccountHeadDTO accountHeadDTO = new AccountHeadDTO();
            accountHeadDTO.setId(id);
            accountHeadServiceRequest.setAccountHeadDTO(accountHeadDTO);
            accountHeadService.deleteAccountHead(accountHeadServiceRequest);
        }
        return null;
    }

    @RequestMapping(value = "createAccountHead", method = RequestMethod.POST)
    @ResponseBody
    public AccountHeadClientModel createAccountHead(@Valid @RequestBody AccountHeadClientModel accountHeadClientModel) {
        return this.constructClientModel(
                accountHeadService.createAccountHead(this.constructServiceRequest(accountHeadClientModel)));
    }

    @RequestMapping(value = "updateAccountHead", method = RequestMethod.POST)
    @ResponseBody
    public AccountHeadClientModel updateAccountHead(@Valid @RequestBody AccountHeadClientModel accountHeadClientModel) {
        return this.constructClientModel(
                accountHeadService.updateAccountHead(this.constructServiceRequest(accountHeadClientModel)));
    }

    @RequestMapping(value = "getAccountHead", method = RequestMethod.POST)
    @ResponseBody
    public AccountHeadClientModel getAccountHead(@RequestBody AccountHeadClientModel accountHeadClientModel) {
        return this.constructClientModel(
                accountHeadService.getAccountHeads(this.constructServiceRequest(accountHeadClientModel)));
    }

    private AccountHeadClientModel constructClientModel(AccountHeadServiceResponse accountHeadServiceResponse) {
        AccountHeadClientModel accountHeadClientModel = null;
        if (accountHeadServiceResponse != null) {
            accountHeadClientModel = new AccountHeadClientModel();
            accountHeadClientModel.setAccountHeadDTOList(accountHeadServiceResponse.getAccountHeadDTOList());
            accountHeadClientModel.setTotalRecords(accountHeadServiceResponse.getTotalRecords());
        }
        return accountHeadClientModel;
    }

    private AccountHeadServiceRequest constructServiceRequest(AccountHeadClientModel accountHeadClientModel) {
        AccountHeadServiceRequest accountHeadServiceRequest = new AccountHeadServiceRequest();
        accountHeadServiceRequest.setAccountHeadDTO(accountHeadClientModel.getAccountHeadDTO());
        accountHeadServiceRequest.setAccountHeadSearchDTO(accountHeadClientModel.getAccountHeadSearchDTO());
        accountHeadServiceRequest.setRecordstoFetch(accountHeadClientModel.getRecordstoFetch());
        accountHeadServiceRequest.setPageIndex(accountHeadClientModel.getPageIndex());
        return accountHeadServiceRequest;
    }
}