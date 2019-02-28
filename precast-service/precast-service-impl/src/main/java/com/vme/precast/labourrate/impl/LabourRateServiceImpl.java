package com.vme.precast.labourrate.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.domain.LabourRate;
import com.vme.precast.labourrate.api.LabourRateDTO;
import com.vme.precast.labourrate.api.LabourRateService;
import com.vme.precast.labourrate.api.LabourRateServiceRequest;
import com.vme.precast.labourrate.api.LabourRateServiceResponse;
import com.vme.precast.repository.ElementTypeRepo;
import com.vme.precast.repository.LabourRateRepo;
import com.vme.precast.repository.ProjectRepo;

public class LabourRateServiceImpl implements LabourRateService {

	@Autowired
	LabourRateRepo labourRateRepo;

	@Autowired
	ElementTypeRepo elementTypeRepo;

	@Autowired
	ProjectRepo projectRepo;

	@Autowired
	ConversionService conversionService;

	@Override
	public LabourRateServiceResponse createLabourRate(LabourRateServiceRequest serviceRequest) {
		LabourRateDTO labourRateDTO = serviceRequest.getLabourRateDTO();
		LabourRate labourRate = conversionService.convert(labourRateDTO, LabourRate.class);
		labourRate.setProject(projectRepo.findById(labourRateDTO.getProjectId()).get());
		labourRate.setElementType(elementTypeRepo.findById(labourRateDTO.getElementTypeId()).get());

		labourRateRepo.save(labourRate);
		return new LabourRateServiceResponse();
	}

	@Override
	public LabourRateServiceResponse getLabourRates(LabourRateServiceRequest serviceRequest) {
		List<LabourRate> labourRates = new ArrayList<>();

		List<Long> ids = serviceRequest.getLabourRateSearchDTO().getIds();
		if (ids != null && !ids.isEmpty()) {
			for (Long id : ids) {
				labourRates.add(labourRateRepo.findById(id).get());
			}
		} else {
			labourRates = (List<LabourRate>) labourRateRepo.findAll();
		}

		List<LabourRateDTO> labourRateDTOs = new ArrayList<>();
		for (LabourRate labourRate : labourRates) {
			labourRateDTOs.add(conversionService.convert(labourRate, LabourRateDTO.class));
		}
		LabourRateServiceResponse serviceResponse = new LabourRateServiceResponse();
		serviceResponse.setLabourRateDTOs(labourRateDTOs);
		return serviceResponse;
	}

	@Override
	public LabourRateServiceResponse updateLabourRate(LabourRateServiceRequest serviceRequest) {
		LabourRateDTO source = serviceRequest.getLabourRateDTO();

		LabourRate target = labourRateRepo.findById(source.getId()).get();
		target.setWorkType(source.getWorkType());
		target.setWorkDesc(source.getWorkDesc());

		target.setNatureOfWork(source.getNatureOfWork());
		target.setUnit(source.getUnit());
		target.setRate(source.getRate());

		target.setProject(projectRepo.findById(source.getProjectId()).get());
		target.setElementType(elementTypeRepo.findById(source.getElementTypeId()).get());

		labourRateRepo.save(target);
		return new LabourRateServiceResponse();
	}

	@Override
	public LabourRateServiceResponse deleteLabourRate(LabourRateServiceRequest serviceRequest) {
		LabourRateDTO labourRateDTO = serviceRequest.getLabourRateDTO();
		labourRateRepo.deleteById(labourRateDTO.getId());
		return new LabourRateServiceResponse();
	}

}
