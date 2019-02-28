package com.vme.precast.element.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.domain.Element;
import com.vme.precast.domain.Mixture;
import com.vme.precast.domain.Project;
import com.vme.precast.element.api.ElementComponent;
import com.vme.precast.element.api.ElementDTO;
import com.vme.precast.element.api.ElementSearchDTO;
import com.vme.precast.element.api.ElementServiceRequest;
import com.vme.precast.element.api.ElementServiceResponse;
import com.vme.precast.repository.ElementRepo;
import com.vme.precast.repository.MixtureRepo;
import com.vme.precast.repository.ProjectRepo;
import com.vme.precast.repository.RawMaterialRepo;
import com.vme.precast.repository.SteelItemRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;

public class ElementComponentImpl implements ElementComponent {

	@Autowired
	ElementRepo elementRepo;

	@Autowired
	SteelItemRepo steelItemRepo;

	@Autowired
	MixtureRepo mixtureRepo;

	@Autowired
	ProjectRepo projectRepo;

	@Autowired
	RawMaterialRepo rawMaterialRepo;

	@Autowired
	ConversionService conversionService;

	@Override
	public ElementServiceResponse createElement(ElementServiceRequest elementServiceRequest) {
		ElementDTO elementDTO = elementServiceRequest.getElementDTO();
		Element element = conversionService.convert(elementDTO, Element.class);
		element.setProject(projectRepo.findById(elementDTO.getProjectId()).get());
		element.setMixture(mixtureRepo.findById(elementDTO.getMixtureId()).get());
		elementRepo.save(element);
		return new ElementServiceResponse();
	}

	@Override
	public ElementServiceResponse getElements(ElementServiceRequest elementServiceRequest) {
		List<Element> elements = new ArrayList<>();
		List<Filter> filters = new ArrayList<>();
		SearchObject searchObject = new SearchObject();

		ElementSearchDTO elementSearchDTO = elementServiceRequest.getElementSearchDTO();
		if (elementSearchDTO != null) {
			List<Long> ids = elementSearchDTO.getIds();
			List<String> names = elementSearchDTO.getNames();
			List<String> codes = elementSearchDTO.getCodes();
			List<String> types = elementSearchDTO.getTypes();
			List<Long> projectIds = elementSearchDTO.getProjectIds();
			List<Long> mixtureIds = elementSearchDTO.getMixtureIds();
//			List<Long> steelItemIds = elementSearchDTO.getSteelItemIds();
			List<Double> theoryQuantitys = elementSearchDTO.getTheoryQuantitys();
			List<Double> weights = elementSearchDTO.getWeights();
			List<Double> lengths = elementSearchDTO.getLengths();
			List<Double> breadths = elementSearchDTO.getBreadths();
			List<Double> theoryAreas = elementSearchDTO.getTheoryAreas();
			List<Double> billingConcreteQuantitys = elementSearchDTO.getBillingConcreteQuantitys();

			createEqualFilter(filters, ElementDTO.ID, ids);
			createEqualFilter(filters, ElementDTO.NAME, names);
			createEqualFilter(filters, ElementDTO.CODE, codes);
			createEqualFilter(filters, ElementDTO.TYPE, types);
			createEqualFilter(filters, ElementDTO.PROJECTID, projectIds);
			createEqualFilter(filters, ElementDTO.MIXTUREID, mixtureIds);
			createEqualFilter(filters, ElementDTO.THEORYQUANTITY, theoryQuantitys);
			createEqualFilter(filters, ElementDTO.WEIGHT, weights);
			createEqualFilter(filters, ElementDTO.LENGTH, lengths);
			createEqualFilter(filters, ElementDTO.BREADTH, breadths);
			createEqualFilter(filters, ElementDTO.THEORYAREA, theoryAreas);
			createEqualFilter(filters, ElementDTO.BILLINGCONCRETEQUANTITY, billingConcreteQuantitys);

			if (CollectionUtils.isNotEmpty(filters)) {
				searchObject.setFilters(filters);
			}
		}
		searchObject.setPageIndex(elementServiceRequest.getPageIndex());
		searchObject.setRecordstoFetch(elementServiceRequest.getRecordstoFetch());
		elements = elementRepo.search(searchObject);

		List<ElementDTO> elementDTOs = new ArrayList<>();
		for (Element target : elements) {
			elementDTOs.add(conversionService.convert(target, ElementDTO.class));
		}
		ElementServiceResponse elementServiceResponse = new ElementServiceResponse();
		elementServiceResponse.setElementDTOs(elementDTOs);
		return elementServiceResponse;
	}

	@Override
	public ElementServiceResponse updateElement(ElementServiceRequest elementServiceRequest) {
		ElementDTO source = elementServiceRequest.getElementDTO();

		Element target = elementRepo.findById(source.getId()).get();
		target.setName(source.getName());
		target.setCode(source.getCode());
		target.setType(source.getType());
		target.setTheoryQuantity(source.getTheoryQuantity());
		target.setWeight(source.getWeight());
		target.setLength(source.getLength());
		target.setBreadth(source.getBreadth());
		target.setTheoryArea(source.getTheoryArea());
		target.setBillingConcreteQuantity(source.getBillingConcreteQuantity());

		if (!target.getProjectId().equals(source.getProjectId())) {
			Project project = projectRepo.findById(source.getProjectId()).get();
			target.setProject(project);
		}
		if (!target.getMixtureId().equals(source.getMixtureId())) {
			Mixture mixture = mixtureRepo.findById(source.getMixtureId()).get();
			target.setMixture(mixture);
		}

		elementRepo.save(target);
		return new ElementServiceResponse();
	}

	@Override
	public ElementServiceResponse deleteElement(ElementServiceRequest elementServiceRequest) {
		ElementDTO elementDTO = elementServiceRequest.getElementDTO();
		elementRepo.deleteById(elementDTO.getId());
		return new ElementServiceResponse();
	}
}
