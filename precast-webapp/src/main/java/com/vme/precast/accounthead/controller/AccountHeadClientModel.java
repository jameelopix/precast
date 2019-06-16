package com.vme.precast.accounthead.controller;

import java.util.List;

import com.vme.precast.accounthead.api.AccountHeadDTO;
import com.vme.precast.accounthead.api.AccountHeadSearchDTO;

import coliseum.web.BaseClientModel;

public class AccountHeadClientModel extends BaseClientModel {

    private static final long serialVersionUID = 1L;

    private AccountHeadDTO accountHeadDTO;

    private AccountHeadSearchDTO accountHeadSearchDTO;

    private List<AccountHeadDTO> accountHeadDTOList;

    public AccountHeadDTO getAccountHeadDTO() {
        return accountHeadDTO;
    }

    public void setAccountHeadDTO(AccountHeadDTO accountHeadDTO) {
        this.accountHeadDTO = accountHeadDTO;
    }

    public List<AccountHeadDTO> getAccountHeadDTOList() {
        return accountHeadDTOList;
    }

    public void setAccountHeadDTOList(List<AccountHeadDTO> accountHeadDTOList) {
        this.accountHeadDTOList = accountHeadDTOList;
    }

    public AccountHeadSearchDTO getAccountHeadSearchDTO() {
        return accountHeadSearchDTO;
    }

    public void setAccountHeadSearchDTO(AccountHeadSearchDTO accountHeadSearchDTO) {
        this.accountHeadSearchDTO = accountHeadSearchDTO;
    }

}