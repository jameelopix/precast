package com.vme.precast.elementtype.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.domain.ElementType;
import com.vme.precast.domain.Project;
import com.vme.precast.elementtype.api.ElementTypeComponent;
import com.vme.precast.elementtype.api.ElementTypeDTO;
import com.vme.precast.elementtype.api.ElementTypeSearchDTO;
import com.vme.precast.elementtype.api.ElementTypeServiceRequest;
import com.vme.precast.elementtype.api.ElementTypeServiceResponse;
import com.vme.precast.project.api.ProjectDTO;
import com.vme.precast.repository.ElementTypeRepo;
import com.vme.precast.repository.ProjectRepo;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;

public class ElementTypeComponentImpl implements ElementTypeComponent {

	@Autowired
	private ElementTypeRepo elementTypeRepo;

	@Autowired
	private ProjectRepo projectRepo;

	@Autowired
	private ConversionService conversionService;

	@Override
	public ElementTypeServiceResponse createElementType(ElementTypeServiceRequest elementTypeServiceRequest) {
		ElementTypeDTO elementTypeDTO = elementTypeServiceRequest.getElementTypeDTO();
		ElementType elementType = conversionService.convert(elementTypeDTO, ElementType.class);
		elementType.setName(elementTypeDTO.getName());

		Project project = projectRepo.findById(elementTypeDTO.getProjectId()).get();
		elementType.setProject(project);

		elementTypeRepo.save(elementType);
		return new ElementTypeServiceResponse();
	}

	@Override
	public ElementTypeServiceResponse getElementTypes(ElementTypeServiceRequest elementTypeServiceRequest) {
		List<ElementType> companies = new ArrayList<>();
		List<Filter> filters = new ArrayList<>();
		SearchObject searchObject = new SearchObject();

		ElementTypeSearchDTO searchDTO = elementTypeServiceRequest.getElementTypeSearchDTO();
		if (searchDTO != null) {
			List<Long> ids = searchDTO.getIds();
			List<String> names = searchDTO.getNames();
			List<Long> projectIds = searchDTO.getProjectIds();
			createEqualFilter(filters, ElementTypeDTO.ID, ids);
			createEqualFilter(filters, ElementTypeDTO.NAME, names);
			createEqualFilter(filters, ElementTypeDTO.PROJECTID, projectIds);

			if (CollectionUtils.isNotEmpty(filters)) {
				searchObject.setFilters(filters);
			}
		}

		Association association = new Association();
		association.setFieldName("project");
		association.setChildless(true);

		searchObject.setAssociations(Arrays.asList(association));
		searchObject.setPageIndex(elementTypeServiceRequest.getPageIndex());
		searchObject.setRecordstoFetch(elementTypeServiceRequest.getRecordstoFetch());
		companies = elementTypeRepo.search(searchObject);

		List<ElementTypeDTO> elementTypeDTOs = new ArrayList<>();
		for (ElementType target : companies) {
			ElementTypeDTO elementTypeDTO = conversionService.convert(target, ElementTypeDTO.class);

			if (target.getProject() != null && target.getProject() instanceof Project) {
				ProjectDTO projectDTO = this.conversionService.convert(target.getProject(), ProjectDTO.class);
				elementTypeDTO.setProjectDTO(projectDTO);
			}

			elementTypeDTOs.add(elementTypeDTO);
		}
		ElementTypeServiceResponse elementTypeServiceResponse = new ElementTypeServiceResponse();
		elementTypeServiceResponse.setElementTypeDTOs(elementTypeDTOs);
		return elementTypeServiceResponse;
	}

	@Override
	public ElementTypeServiceResponse updateElementType(ElementTypeServiceRequest elementTypeServiceRequest) {
		ElementTypeDTO source = elementTypeServiceRequest.getElementTypeDTO();

		ElementType target = elementTypeRepo.findById(source.getId()).get();
		if (!target.getProjectId().equals(source.getProjectId())) {
			Project project = projectRepo.findById(source.getProjectId()).get();
			target.setProject(project);
		}

		target.setName(source.getName());
		elementTypeRepo.save(target);

		return new ElementTypeServiceResponse();
	}

	@Override
	public ElementTypeServiceResponse deleteElementType(ElementTypeServiceRequest elementTypeServiceRequest) {
		ElementTypeDTO source = elementTypeServiceRequest.getElementTypeDTO();
		elementTypeRepo.deleteById(source.getId());
		return new ElementTypeServiceResponse();
	}
}
