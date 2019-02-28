package com.vme.precast.labouractivity.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.domain.LabourActivity;
import com.vme.precast.labouractivity.api.LabourActivityDTO;
import com.vme.precast.labouractivity.api.LabourActivityService;
import com.vme.precast.labouractivity.api.LabourActivityServiceRequest;
import com.vme.precast.labouractivity.api.LabourActivityServiceResponse;
import com.vme.precast.repository.CastingActivityRepo;
import com.vme.precast.repository.LabourActivityRepo;
import com.vme.precast.repository.SubContractorRepo;

//@tran
public class LabourActivityServiceImpl implements LabourActivityService {

	@Autowired
	LabourActivityRepo labourActivityRepo;

	@Autowired
	CastingActivityRepo castingActivityRepo;

	@Autowired
	SubContractorRepo subContractorRepo;

	@Autowired
	ConversionService conversionService;

	@Override
	public LabourActivityServiceResponse createLabourActivity(LabourActivityServiceRequest serviceRequest) {
		LabourActivityDTO labourActivityDTO = serviceRequest.getLabourActivityDTO();
		LabourActivity labourActivity = conversionService.convert(labourActivityDTO, LabourActivity.class);
		labourActivity.setCastingActivity(castingActivityRepo.findById(labourActivityDTO.getCastingActivityId()).get());
		labourActivity.setSubContractor(subContractorRepo.findById(labourActivityDTO.getSubContractorId()).get());
		labourActivityRepo.save(labourActivity);
		return new LabourActivityServiceResponse();
	}

	@Override
	public LabourActivityServiceResponse getLabourActivitys(LabourActivityServiceRequest serviceRequest) {
		List<LabourActivity> labourActivitys = new ArrayList<>();

		List<Long> ids = serviceRequest.getLabourActivitySearchDTO().getIds();
		if (ids != null && !ids.isEmpty()) {
			for (Long id : ids) {
				labourActivitys.add(labourActivityRepo.findById(id).get());
			}
		} else {
			labourActivitys = (List<LabourActivity>) labourActivityRepo.findAll();
		}

		List<LabourActivityDTO> labourActivityDTOs = new ArrayList<>();
		for (LabourActivity labourActivity : labourActivitys) {
			labourActivityDTOs.add(conversionService.convert(labourActivity, LabourActivityDTO.class));
		}
		LabourActivityServiceResponse serviceResponse = new LabourActivityServiceResponse();
		serviceResponse.setLabourActivityDTOs(labourActivityDTOs);
		return serviceResponse;
	}

	@Override
	public LabourActivityServiceResponse updateLabourActivity(LabourActivityServiceRequest serviceRequest) {
		LabourActivityDTO source = serviceRequest.getLabourActivityDTO();

		LabourActivity target = labourActivityRepo.findById(source.getId()).get();
		target.setNatureOfWork(source.getNatureOfWork());
		target.setQuantity(source.getQuantity());
		target.setCastingActivity(castingActivityRepo.findById(source.getCastingActivityId()).get());
		target.setSubContractor(subContractorRepo.findById(source.getSubContractorId()).get());

		labourActivityRepo.save(target);
		return new LabourActivityServiceResponse();
	}

	@Override
	public LabourActivityServiceResponse deleteLabourActivity(LabourActivityServiceRequest serviceRequest) {
		LabourActivityDTO labourActivityDTO = serviceRequest.getLabourActivityDTO();
		labourActivityRepo.deleteById(labourActivityDTO.getId());
		return new LabourActivityServiceResponse();
	}

}
