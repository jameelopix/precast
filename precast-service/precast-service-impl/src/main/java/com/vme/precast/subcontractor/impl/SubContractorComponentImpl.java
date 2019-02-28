package com.vme.precast.subcontractor.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.domain.SubContractor;
import com.vme.precast.repository.SubContractorRepo;
import com.vme.precast.subcontractor.api.SubContractorComponent;
import com.vme.precast.subcontractor.api.SubContractorDTO;
import com.vme.precast.subcontractor.api.SubContractorSearchDTO;
import com.vme.precast.subcontractor.api.SubContractorServiceRequest;
import com.vme.precast.subcontractor.api.SubContractorServiceResponse;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;

public class SubContractorComponentImpl implements SubContractorComponent {

	@Autowired
	SubContractorRepo subContractorRepo;

	@Autowired
	ConversionService conversionService;

	@Override
	public SubContractorServiceResponse createSubContractor(SubContractorServiceRequest subContractorServiceRequest) {
		SubContractorDTO source = subContractorServiceRequest.getSubContractorDTO();
		SubContractor target = conversionService.convert(source, SubContractor.class);
		subContractorRepo.save(target);
		return new SubContractorServiceResponse();
	}

	@Override
	public SubContractorServiceResponse getSubContractors(SubContractorServiceRequest subContractorServiceRequest) {
		List<SubContractor> companies = new ArrayList<>();
		List<Filter> filters = new ArrayList<>();
		SearchObject searchObject = new SearchObject();

		SubContractorSearchDTO searchDTO = subContractorServiceRequest.getSubContractorSearchDTO();
		if (searchDTO != null) {
			List<Long> ids = searchDTO.getIds();
			List<String> names = searchDTO.getNames();
			List<String> panNumbers = searchDTO.getPanNumbers();
			List<Double> retentionPercents = searchDTO.getRetentionPercents();
			List<Double> tdsPercents = searchDTO.getTdsPercents();
			createEqualFilter(filters, SubContractorDTO.ID, ids);
			createEqualFilter(filters, SubContractorDTO.NAME, names);
			createEqualFilter(filters, SubContractorDTO.PANNUMBER, panNumbers);
			createEqualFilter(filters, SubContractorDTO.RETENTIONPERCENT, retentionPercents);
			createEqualFilter(filters, SubContractorDTO.TDSPERCENT, tdsPercents);

			if (CollectionUtils.isNotEmpty(filters)) {
				searchObject.setFilters(filters);
			}
		}

		searchObject.setPageIndex(subContractorServiceRequest.getPageIndex());
		searchObject.setRecordstoFetch(subContractorServiceRequest.getRecordstoFetch());
		companies = subContractorRepo.search(searchObject);

		List<SubContractorDTO> subContractorDTOs = new ArrayList<>();
		for (SubContractor target : companies) {
			SubContractorDTO subContractorDTO = conversionService.convert(target, SubContractorDTO.class);

			subContractorDTOs.add(subContractorDTO);
		}
		SubContractorServiceResponse subContractorServiceResponse = new SubContractorServiceResponse();
		subContractorServiceResponse.setSubContractorDTOs(subContractorDTOs);
		return subContractorServiceResponse;
	}

	@Override
	public SubContractorServiceResponse updateSubContractor(SubContractorServiceRequest subContractorServiceRequest) {
		SubContractorDTO source = subContractorServiceRequest.getSubContractorDTO();

		SubContractor target = subContractorRepo.findById(source.getId()).get();
		target.setName(source.getName());
		target.setPanNumber(source.getPanNumber());
		target.setRetentionPercent(source.getRetentionPercent());
		target.setTdsPercent(source.getTdsPercent());

		subContractorRepo.save(target);
		return new SubContractorServiceResponse();
	}

	@Override
	public SubContractorServiceResponse deleteSubContractor(SubContractorServiceRequest subContractorServiceRequest) {
		SubContractorDTO projectDTO = subContractorServiceRequest.getSubContractorDTO();
		subContractorRepo.deleteById(projectDTO.getId());
		return new SubContractorServiceResponse();
	}
}
