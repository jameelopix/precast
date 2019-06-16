package com.vme.precast.accountdetails.api;

import java.util.List;

import com.vme.precast.company.api.CompanyDTO;
import com.vme.precast.shared.AccountType;

import coliseum.service.BaseSearchDTO;

public class AccountDetailsSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> accountNameList;
    private List<String> accountNumberList;
    private List<AccountType> accountTypeList;
    private List<CompanyDTO> companyDTOList;
    private List<Long> companyIdList;

    public static String ID = "id";
    public static String ACCOUNTNAME = "accountName";
    public static String ACCOUNTNUMBER = "accountNumber";
    public static String ACCOUNTTYPE = "accountType";
    public static String COMPANY = "company";
    public static String COMPANYID = "companyId";

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getAccountNameList() {
        return accountNameList;
    }

    public void setAccountNameList(List<String> accountNameList) {
        this.accountNameList = accountNameList;
    }

    public List<String> getAccountNumberList() {
        return accountNumberList;
    }

    public void setAccountNumberList(List<String> accountNumberList) {
        this.accountNumberList = accountNumberList;
    }

    public List<AccountType> getAccountTypeList() {
        return accountTypeList;
    }

    public void setAccountTypeList(List<AccountType> accountTypeList) {
        this.accountTypeList = accountTypeList;
    }

    public List<CompanyDTO> getCompanyDTOList() {
        return companyDTOList;
    }

    public void setCompanyDTOList(List<CompanyDTO> companyDTOList) {
        this.companyDTOList = companyDTOList;
    }

    public List<Long> getCompanyIdList() {
        return companyIdList;
    }

    public void setCompanyIdList(List<Long> companyIdList) {
        this.companyIdList = companyIdList;
    }
}