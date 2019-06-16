package com.vme.precast.accountdetails.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.accountdetails.api.AccountDetailsDTO;
import com.vme.precast.company.api.CompanyDTO;
import com.vme.precast.domain.AccountDetails;
import com.vme.precast.domain.Company;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class AccountDetailsGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(AccountDetails.class, AccountDetailsDTO.class));
        convertiblePairs.add(new ConvertiblePair(AccountDetailsDTO.class, AccountDetails.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == AccountDetails.class && targetType.getType() == AccountDetailsDTO.class) {
            target = this.convertToAccountDetailsDTO((AccountDetails) source);
        }
        if (sourceType.getType() == AccountDetailsDTO.class && targetType.getType() == AccountDetails.class) {
            target = this.convertToAccountDetails((AccountDetailsDTO) source);
        }
        return target;
    }

    private Object convertToAccountDetails(AccountDetailsDTO source) {
        AccountDetails target = new AccountDetails();
        target.setId(source.getId());
        target.setAccountName(source.getAccountName());
        target.setAccountNumber(source.getAccountNumber());
        target.setAccountType(source.getAccountType());

        if (source.getCompanyDTO() != null) {
            target.setCompany(
                    (Company) conversionUtility.convert(source.getCompanyDTO(), CompanyDTO.class, Company.class));
        }
        target.setCompanyId(source.getCompanyId());
        return target;
    }

    private Object convertToAccountDetailsDTO(AccountDetails source) {
        AccountDetailsDTO target = new AccountDetailsDTO();
        target.setId(source.getId());
        target.setAccountName(source.getAccountName());
        target.setAccountNumber(source.getAccountNumber());
        target.setAccountType(source.getAccountType());

        if (RepoUtils.isNotProxy(source.getCompany())) {
            target.setCompanyDTO(
                    (CompanyDTO) conversionUtility.convert(source.getCompany(), Company.class, CompanyDTO.class));
        }
        target.setCompanyId(source.getCompanyId());
        return target;
    }
}
