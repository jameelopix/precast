package com.vme.precast.mixtureitem.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.domain.MixtureItem;
import com.vme.precast.mixtureitem.api.MixtureItemDTO;
import com.vme.precast.mixtureitem.api.MixtureItemService;
import com.vme.precast.mixtureitem.api.MixtureItemServiceRequest;
import com.vme.precast.mixtureitem.api.MixtureItemServiceResponse;
import com.vme.precast.repository.MixtureItemRepo;
import com.vme.precast.repository.MixtureRepo;
import com.vme.precast.repository.RawMaterialRepo;

//@tran
public class MixtureItemServiceImpl implements MixtureItemService {

	@Autowired
	MixtureItemRepo mixtureItemRepo;

	@Autowired
	MixtureRepo mixtureRepo;

	@Autowired
	RawMaterialRepo rawMaterialRepo;

	@Autowired
	ConversionService conversionService;

	@Override
	public MixtureItemServiceResponse createMixtureItem(MixtureItemServiceRequest serviceRequest) {
		MixtureItemDTO mixtureItemDTO = serviceRequest.getMixtureItemDTO();
		MixtureItem mixtureItem = conversionService.convert(mixtureItemDTO, MixtureItem.class);
		mixtureItem.setMixture(mixtureRepo.findById(mixtureItemDTO.getMixtureId()).get());
		mixtureItem.setRawMaterial(rawMaterialRepo.findById(mixtureItemDTO.getRawMaterialId()).get());

		mixtureItemRepo.save(mixtureItem);
		return new MixtureItemServiceResponse();
	}

	@Override
	public MixtureItemServiceResponse getMixtureItems(MixtureItemServiceRequest serviceRequest) {
		List<MixtureItem> targets = (List<MixtureItem>) mixtureItemRepo.findAll();

		List<MixtureItemDTO> mixtureDTOs = new ArrayList<>();
		for (MixtureItem target : targets) {
			mixtureDTOs.add(conversionService.convert(target, MixtureItemDTO.class));
		}
		MixtureItemServiceResponse serviceResponse = new MixtureItemServiceResponse();
		serviceResponse.setMixtureItemDTOs(mixtureDTOs);
		return serviceResponse;
	}

	@Override
	public MixtureItemServiceResponse updateMixtureItem(MixtureItemServiceRequest serviceRequest) {
		MixtureItemDTO source = serviceRequest.getMixtureItemDTO();

		MixtureItem target = mixtureItemRepo.findById(source.getId()).get();
		target.setQuantity(source.getQuantity());
		target.setMixture(mixtureRepo.findById(source.getMixtureId()).get());
		target.setRawMaterial(rawMaterialRepo.findById(source.getRawMaterialId()).get());

		mixtureItemRepo.save(target);
		return new MixtureItemServiceResponse();
	}

	@Override
	public MixtureItemServiceResponse deleteMixtureItem(MixtureItemServiceRequest serviceRequest) {
		MixtureItemDTO mixtureDTO = serviceRequest.getMixtureItemDTO();
		mixtureItemRepo.deleteById(mixtureDTO.getId());
		return new MixtureItemServiceResponse();
	}
}
