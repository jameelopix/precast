package com.vme.precast.company.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.company.api.CompanyComponent;
import com.vme.precast.company.api.CompanyDTO;
import com.vme.precast.company.api.CompanySearchDTO;
import com.vme.precast.company.api.CompanyServiceRequest;
import com.vme.precast.company.api.CompanyServiceResponse;
import com.vme.precast.domain.Company;
import com.vme.precast.repository.CompanyRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;

public class CompanyComponentImpl implements CompanyComponent {

	@Autowired
	private CompanyRepo companyRepo;

	@Autowired
	private ConversionService conversionService;

	@Override
	public CompanyServiceResponse createCompany(CompanyServiceRequest companyServiceRequest) {
		CompanyDTO companyDTO = companyServiceRequest.getCompanyDTO();
		Company company = conversionService.convert(companyDTO, Company.class);
		company.setSelfCompany(false);
		company.setDisabled(false);
		companyRepo.save(company);
		return new CompanyServiceResponse();
	}

	@Override
	public CompanyServiceResponse getCompanys(CompanyServiceRequest companyServiceRequest) {
		List<Company> companies = new ArrayList<>();
		List<Filter> filters = new ArrayList<>();
		SearchObject searchObject = new SearchObject();

		CompanySearchDTO searchDTO = companyServiceRequest.getCompanySearchDTO();
		if (searchDTO != null) {
			List<Long> ids = searchDTO.getIds();
			List<String> names = searchDTO.getNames();
			List<Boolean> selfCompanys = searchDTO.getSelfCompanys();
			createEqualFilter(filters, CompanyDTO.ID, ids);
			createEqualFilter(filters, CompanyDTO.NAME, names);
			createEqualFilter(filters, CompanyDTO.SELF_COMPANY, selfCompanys);

			// Remove disabled companies
			createEqualFilter(filters, CompanyDTO.DISABLED, false);

			if (CollectionUtils.isNotEmpty(filters)) {
				searchObject.setFilters(filters);
			}
		}
		searchObject.setPageIndex(companyServiceRequest.getPageIndex());
		searchObject.setRecordstoFetch(companyServiceRequest.getRecordstoFetch());
		companies = companyRepo.search(searchObject);

		List<CompanyDTO> companyDTOs = new ArrayList<>();
		for (Company target : companies) {
			companyDTOs.add(conversionService.convert(target, CompanyDTO.class));
		}
		CompanyServiceResponse companyServiceResponse = new CompanyServiceResponse();
		companyServiceResponse.setCompanyDTOs(companyDTOs);
		return companyServiceResponse;
	}

	@Override
	public CompanyServiceResponse updateCompany(CompanyServiceRequest companyServiceRequest) {
		CompanyDTO source = companyServiceRequest.getCompanyDTO();

		Company target = companyRepo.findById(source.getId()).get();
		target.setName(source.getName());
		companyRepo.save(target);

		return new CompanyServiceResponse();
	}

	@Override
	public CompanyServiceResponse deleteCompany(CompanyServiceRequest companyServiceRequest) {
		CompanyDTO source = companyServiceRequest.getCompanyDTO();

		Company target = companyRepo.findById(source.getId()).get();
		target.setDisabled(true);
		companyRepo.save(target);

		return new CompanyServiceResponse();
	}
}