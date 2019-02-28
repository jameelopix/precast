package com.vme.precast.castingactivity.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.castingactivity.api.CastingActivityDTO;
import com.vme.precast.castingactivity.api.CastingActivityService;
import com.vme.precast.castingactivity.api.CastingActivityServiceRequest;
import com.vme.precast.castingactivity.api.CastingActivityServiceResponse;
import com.vme.precast.domain.CastingActivity;
import com.vme.precast.domain.Element;
import com.vme.precast.repository.CastingActivityRepo;
import com.vme.precast.repository.ElementRepo;

public class CastingActivityServiceImpl implements CastingActivityService {

	@Autowired
	CastingActivityRepo castingActivityRepo;

	@Autowired
	ElementRepo elementRepo;

	@Autowired
	ConversionService conversionService;

	@Override
	public CastingActivityServiceResponse createCastingActivity(CastingActivityServiceRequest serviceRequest) {
		CastingActivityDTO castingActivityDTO = serviceRequest.getCastingActivityDTO();
		CastingActivity castingActivity = conversionService.convert(castingActivityDTO, CastingActivity.class);
		castingActivityRepo.save(castingActivity);
		return new CastingActivityServiceResponse();
	}

	@Override
	public CastingActivityServiceResponse getCastingActivitys(CastingActivityServiceRequest serviceRequest) {
		List<CastingActivity> castingActivities = new ArrayList<>();

		List<Long> ids = serviceRequest.getCastingActivitySearchDTO().getIds();
		if (ids != null && !ids.isEmpty()) {
			for (Long id : ids) {
				castingActivities.add(castingActivityRepo.findById(id).get());
			}
		} else {
			castingActivities = (List<CastingActivity>) castingActivityRepo.findAll();
		}

		List<CastingActivityDTO> castingActivityDTOs = new ArrayList<>();
		for (CastingActivity castingActivity : castingActivities) {
			castingActivityDTOs.add(conversionService.convert(castingActivity, CastingActivityDTO.class));
		}
		CastingActivityServiceResponse serviceResponse = new CastingActivityServiceResponse();
		serviceResponse.setCastingActivityDTOs(castingActivityDTOs);
		return serviceResponse;
	}

	@Override
	public CastingActivityServiceResponse updateCastingActivity(CastingActivityServiceRequest serviceRequest) {
		CastingActivityDTO source = serviceRequest.getCastingActivityDTO();

		Element element = elementRepo.findById(source.getElementId()).get();

		CastingActivity target = castingActivityRepo.findById(source.getId()).get();
		target.setElement(element);
		target.setCastedDate(source.getCastedDate());
		target.setActualConcentreQuantity(source.getActualConcentreQuantity());

		castingActivityRepo.save(target);
		return new CastingActivityServiceResponse();
	}

	@Override
	public CastingActivityServiceResponse deleteCastingActivity(CastingActivityServiceRequest serviceRequest) {
		CastingActivityDTO castingActivityDTO = serviceRequest.getCastingActivityDTO();
		castingActivityRepo.deleteById(castingActivityDTO.getId());
		return new CastingActivityServiceResponse();
	}
}
