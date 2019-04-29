package com.vme.precast.company.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.company.api.CompanyComponent;
import com.vme.precast.company.api.CompanyDTO;
import com.vme.precast.company.api.CompanySearchDTO;
import com.vme.precast.company.api.CompanyServiceRequest;
import com.vme.precast.company.api.CompanyServiceResponse;
import com.vme.precast.domain.Company;
import com.vme.precast.repository.CompanyRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class CompanyComponentImpl implements CompanyComponent {
    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public CompanyServiceResponse createCompany(CompanyServiceRequest companyServiceRequest) {
        CompanyDTO companyDTO = companyServiceRequest.getCompanyDTO();
        Company company = (Company) conversionUtility.convert(companyDTO, CompanyDTO.class, Company.class);
        companyRepo.save(company);
        return null;
    }

    @Override
    public CompanyServiceResponse getCompanys(CompanyServiceRequest companyServiceRequest) {
        List<Company> companyList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        CompanySearchDTO companySearchDTO = companyServiceRequest.getCompanySearchDTO();
        if (companySearchDTO != null) {
            List<Long> idList = companySearchDTO.getIdList();
            List<String> nameList = companySearchDTO.getNameList();

            FilterUtils.createEqualFilter(filters, CompanySearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, CompanySearchDTO.NAME, nameList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(companyServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(companyServiceRequest.getRecordstoFetch());
        companyList = companyRepo.search(searchObject);

        List<CompanyDTO> companyDTOList = new ArrayList<>();
        for (Company target : companyList) {
            companyDTOList.add((CompanyDTO) conversionUtility.convert(target, Company.class, CompanyDTO.class));
        }
        CompanyServiceResponse companyServiceResponse = new CompanyServiceResponse();
        companyServiceResponse.setCompanyDTOList(companyDTOList);
        return companyServiceResponse;
    }

    @Override
    public CompanyServiceResponse updateCompany(CompanyServiceRequest companyServiceRequest) {
        CompanyDTO source = companyServiceRequest.getCompanyDTO();

        Company target = companyRepo.findById(source.getId()).get();
        target.setName(source.getName());

        companyRepo.save(target);
        return null;
    }

    @Override
    public CompanyServiceResponse deleteCompany(CompanyServiceRequest companyServiceRequest) {
        CompanyDTO companyDTO = companyServiceRequest.getCompanyDTO();
        companyRepo.deleteById(companyDTO.getId());
        return null;
    }
}