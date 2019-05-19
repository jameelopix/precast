package com.vme.precast.accountdetails.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class AccountDetailsSearchDTO extends BaseSearchDTO {

    private static final long serialVersionUID = 1L;
    private List<Long> idList;
    private List<String> accountNameList;
    private List<String> accountNumberList;
//    private List<AccountType> accountTypeList;
//    private List<Company> companyList;
    private List<Long> companyIdList;

    public static String ID = "id";
    public static String ACCOUNTNAME = "accountName";
    public static String ACCOUNTNUMBER = "accountNumber";
    public static String ACCOUNTTYPE = "accountType";
    public static String COMPANY = "company";
    public static String COMPANYID = "companyId";

}