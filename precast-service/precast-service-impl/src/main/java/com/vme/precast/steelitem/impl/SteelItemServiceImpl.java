package com.vme.precast.steelitem.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.domain.Element;
import com.vme.precast.domain.RawMaterial;
import com.vme.precast.domain.SteelItem;
import com.vme.precast.repository.ElementRepo;
import com.vme.precast.repository.RawMaterialRepo;
import com.vme.precast.repository.SteelItemRepo;
import com.vme.precast.steelitem.api.SteelItemDTO;
import com.vme.precast.steelitem.api.SteelItemService;
import com.vme.precast.steelitem.api.SteelItemServiceRequest;
import com.vme.precast.steelitem.api.SteelItemServiceResponse;

public class SteelItemServiceImpl implements SteelItemService {

	@Autowired
	SteelItemRepo steelItemRepo;

	@Autowired
	ElementRepo elementRepo;

	@Autowired
	RawMaterialRepo rawMaterialRepo;

	@Autowired
	ConversionService conversionService;

	@Override
	public SteelItemServiceResponse createSteelItem(SteelItemServiceRequest serviceRequest) {
		SteelItemDTO source = serviceRequest.getSteelItemDTO();
		SteelItem target = conversionService.convert(source, SteelItem.class);
		target.setElement(elementRepo.findById(source.getElementId()).get());
		target.setRawMaterial(rawMaterialRepo.findById(source.getRawMaterialId()).get());
		steelItemRepo.save(target);
		return new SteelItemServiceResponse();
	}

	@Override
	public SteelItemServiceResponse getSteelItems(SteelItemServiceRequest serviceRequest) {
		List<SteelItem> targets = (List<SteelItem>) steelItemRepo.findAll();

		List<SteelItemDTO> steelItemDTOs = new ArrayList<>();
		for (SteelItem target : targets) {
			steelItemDTOs.add(conversionService.convert(target, SteelItemDTO.class));
		}
		SteelItemServiceResponse serviceResponse = new SteelItemServiceResponse();
		serviceResponse.setSteelItemDTOs(steelItemDTOs);
		return serviceResponse;
	}

	@Override
	public SteelItemServiceResponse updateSteelItem(SteelItemServiceRequest serviceRequest) {
		SteelItemDTO source = serviceRequest.getSteelItemDTO();

		Element element = elementRepo.findById(source.getElementId()).get();
		RawMaterial rawMaterial = rawMaterialRepo.findById(source.getRawMaterialId()).get();

		SteelItem target = steelItemRepo.findById(source.getId()).get();
		target.setTheoryQuantity(source.getTheoryQuantity());
		target.setActualQuantity(source.getActualQuantity());
		target.setElement(element);
		target.setRawMaterial(rawMaterial);

		steelItemRepo.save(target);
		return new SteelItemServiceResponse();
	}

	@Override
	public SteelItemServiceResponse deleteSteelItem(SteelItemServiceRequest serviceRequest) {
		SteelItemDTO projectDTO = serviceRequest.getSteelItemDTO();
		steelItemRepo.deleteById(projectDTO.getId());
		return new SteelItemServiceResponse();
	}
}
