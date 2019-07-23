package com.vme.precast.company.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.company.api.CompanyDTO;
import com.vme.precast.company.api.CompanySearchDTO;
import com.vme.precast.company.api.CompanyServiceRequest;
import com.vme.precast.company.api.CompanyValidator;
import com.vme.precast.domain.Company;
import com.vme.precast.repository.CompanyRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ErrorDTO;
import coliseum.service.FilterUtils;

public class CompanyValidatorImpl implements CompanyValidator {
    @Autowired
    CompanyRepo companyRepo;

    @Override
    public ErrorDTO checkCompanyDuplicate(CompanyServiceRequest companyServiceRequest) {
        ErrorDTO errorDTO = null;
        CompanyDTO companyDTO = companyServiceRequest.getCompanyDTO();

        SearchObject searchObject = new SearchObject();
        List<Filter> filters = new ArrayList<>();
        FilterUtils.createEqualFilter(filters, CompanySearchDTO.NAME, companyDTO.getName());
        if (CollectionUtils.isNotEmpty(filters)) {
            searchObject.setFilters(filters);
        }
        List<Company> companyList = companyRepo.search(searchObject);

        if (CollectionUtils.isNotEmpty(companyList)) {
            for (Company company : companyList) {
                if (!company.getId().equals(companyDTO.getId())) {
                    errorDTO = new ErrorDTO("ERR_VR_100", "Company already exists!!!");
                    break;
                }
            }
        }
        return errorDTO;
    }
}
