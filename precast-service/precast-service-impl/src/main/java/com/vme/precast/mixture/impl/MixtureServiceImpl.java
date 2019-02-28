package com.vme.precast.mixture.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.domain.Mixture;
import com.vme.precast.mixture.api.MixtureDTO;
import com.vme.precast.mixture.api.MixtureService;
import com.vme.precast.mixture.api.MixtureServiceRequest;
import com.vme.precast.mixture.api.MixtureServiceResponse;
import com.vme.precast.repository.MixtureItemRepo;
import com.vme.precast.repository.MixtureRepo;
import com.vme.precast.repository.RawMaterialRepo;

//@tran
public class MixtureServiceImpl implements MixtureService {

	@Autowired
	MixtureRepo mixtureRepo;

	@Autowired
	MixtureItemRepo mixtureItemRepo;

	@Autowired
	RawMaterialRepo rawMaterialRepo;

	@Autowired
	ConversionService conversionService;

	@Override
	public MixtureServiceResponse createMixture(MixtureServiceRequest serviceRequest) {
		MixtureDTO mixtureDTO = serviceRequest.getMixtureDTO();
		Mixture mixture = conversionService.convert(mixtureDTO, Mixture.class);
		mixtureRepo.save(mixture);
		return new MixtureServiceResponse();
	}

	@Override
	public MixtureServiceResponse getMixtures(MixtureServiceRequest serviceRequest) {
		List<Mixture> targets = (List<Mixture>) mixtureRepo.findAll();

		List<MixtureDTO> mixtureDTOs = new ArrayList<>();
		for (Mixture target : targets) {
			mixtureDTOs.add(conversionService.convert(target, MixtureDTO.class));
		}
		MixtureServiceResponse serviceResponse = new MixtureServiceResponse();
		serviceResponse.setMixtureDTOs(mixtureDTOs);
		return serviceResponse;
	}

	@Override
	public MixtureServiceResponse updateMixture(MixtureServiceRequest serviceRequest) {
		MixtureDTO source = serviceRequest.getMixtureDTO();

		Mixture target = mixtureRepo.findById(source.getId()).get();
		target.setCode(source.getCode());
//		Set<MixtureItemDTO> mixtureItemDTOs = source.getMixtureItemDTOs();
//		Set<MixtureItem> mixtureItems = new HashSet<>();
//		for (MixtureItemDTO mixtureItemDTO : mixtureItemDTOs) {
//			MixtureItem mixtureItem = new MixtureItem();
//			mixtureItem.setQuantity(mixtureItemDTO.getQuantity());
//			mixtureItem.setRawMaterial(rawMaterialRepo.findById(mixtureItemDTO.getRawMaterialId()));
//			mixtureItems.add(mixtureItem);
//		}
//		target.setMixtureItems(mixtureItems);

		mixtureRepo.save(target);
		return new MixtureServiceResponse();
	}

	@Override
	public MixtureServiceResponse deleteMixture(MixtureServiceRequest serviceRequest) {
		MixtureDTO mixtureDTO = serviceRequest.getMixtureDTO();
		mixtureRepo.deleteById(mixtureDTO.getId());
		return new MixtureServiceResponse();
	}
}
