package com.vme.precast.rawmaterial.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Repository;

import com.vme.precast.domain.RawMaterial;
import com.vme.precast.rawmaterial.api.RawMaterialComponent;
import com.vme.precast.rawmaterial.api.RawMaterialDTO;
import com.vme.precast.rawmaterial.api.RawMaterialService;
import com.vme.precast.rawmaterial.api.RawMaterialServiceRequest;
import com.vme.precast.rawmaterial.api.RawMaterialServiceResponse;
import com.vme.precast.repository.RawMaterialRepo;

//@tran
public class RawMaterialComponentImpl implements RawMaterialComponent, ApplicationContextAware {

	@Autowired
	private RawMaterialRepo rawMaterialRepo;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private ApplicationContext context;

	@Override
	public RawMaterialServiceResponse createRawMaterial(RawMaterialServiceRequest serviceRequest) {
		RawMaterialDTO rawMaterialDTO = serviceRequest.getRawMaterialDTO();
		RawMaterial rawMaterial = conversionService.convert(rawMaterialDTO, RawMaterial.class);
		rawMaterialRepo.save(rawMaterial);
		return new RawMaterialServiceResponse();
	}

	@Override
	public RawMaterialServiceResponse getRawMaterials(RawMaterialServiceRequest serviceRequest) {
		this.getDetails();
		List<RawMaterial> rawMaterials = new ArrayList<>();

		List<Long> ids = serviceRequest.getRawMaterialSearchDTO().getIds();
		if (ids != null && !ids.isEmpty()) {
			for (Long id : ids) {
				rawMaterials.add(rawMaterialRepo.findById(id).get());
			}
		} else {
			rawMaterials = (List<RawMaterial>) rawMaterialRepo.findAll();
		}

		List<RawMaterialDTO> rawMaterialDTOs = new ArrayList<>();
		for (RawMaterial target : rawMaterials) {
			rawMaterialDTOs.add(conversionService.convert(target, RawMaterialDTO.class));
		}
		RawMaterialServiceResponse rawMaterialServiceResponse = new RawMaterialServiceResponse();
		rawMaterialServiceResponse.setRawMaterialDTOs(rawMaterialDTOs);
		return rawMaterialServiceResponse;
	}

	private void getDetails() {
		Map<String, Object> map = context.getBeansWithAnnotation(Repository.class);
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
		System.out.println("--------------------------------");
		Map<String, RawMaterialService> map1 = context.getBeansOfType(RawMaterialService.class);
		for (Entry<String, RawMaterialService> entry : map1.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
	}

	@Override
	public RawMaterialServiceResponse updateRawMaterial(RawMaterialServiceRequest serviceRequest) {
		RawMaterialDTO source = serviceRequest.getRawMaterialDTO();

		RawMaterial target = rawMaterialRepo.findById(source.getId()).get();
		target.setName(source.getName());
		target.setType(source.getType());
		target.setUnit(source.getUnit());

		rawMaterialRepo.save(target);
		return new RawMaterialServiceResponse();
	}

	@Override
	public RawMaterialServiceResponse deleteRawMaterial(RawMaterialServiceRequest serviceRequest) {
		RawMaterialDTO rawMaterialDTO = serviceRequest.getRawMaterialDTO();
		rawMaterialRepo.deleteById(rawMaterialDTO.getId());
		return new RawMaterialServiceResponse();
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = arg0;
	}
}
