package com.vme.precast.workdetail.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.domain.ElementType;
import com.vme.precast.domain.Project;
import com.vme.precast.domain.WorkDetail;
import com.vme.precast.repository.ElementTypeRepo;
import com.vme.precast.repository.ProjectRepo;
import com.vme.precast.repository.WorkDetailRepo;
import com.vme.precast.workdetail.api.WorkDetailComponent;
import com.vme.precast.workdetail.api.WorkDetailDTO;
import com.vme.precast.workdetail.api.WorkDetailSearchDTO;
import com.vme.precast.workdetail.api.WorkDetailServiceRequest;
import com.vme.precast.workdetail.api.WorkDetailServiceResponse;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;

public class WorkDetailComponentImpl implements WorkDetailComponent {

	@Autowired
	WorkDetailRepo workDetailRepo;

	@Autowired
	ProjectRepo projectRepo;

	@Autowired
	ElementTypeRepo elementTypeRepo;

	@Autowired
	ConversionService conversionService;

	@Override
	public WorkDetailServiceResponse createWorkDetail(WorkDetailServiceRequest serviceRequest) {
		WorkDetailDTO source = serviceRequest.getWorkDetailDTO();
		WorkDetail target = conversionService.convert(source, WorkDetail.class);
		target.setProject(projectRepo.findById(source.getProjectId()).get());
		target.setElementType(elementTypeRepo.findById(source.getElementTypeId()).get());
		workDetailRepo.save(target);
		return new WorkDetailServiceResponse();
	}

	@Override
	public WorkDetailServiceResponse getWorkDetails(WorkDetailServiceRequest workDetailServiceRequest) {
		List<WorkDetail> workDetails = new ArrayList<>();
		List<Filter> filters = new ArrayList<>();
		SearchObject searchObject = new SearchObject();

		WorkDetailSearchDTO searchDTO = workDetailServiceRequest.getWorkDetailSearchDTO();
		if (searchDTO != null) {
			List<Long> ids = searchDTO.getIds();
			List<Long> projectIds = searchDTO.getProjectIds();
			List<Long> elementTypeIds = searchDTO.getElementTypeIds();
			List<String> workNatures = searchDTO.getWorkNatures();
			List<String> workDescs = searchDTO.getWorkDescs();

			createEqualFilter(filters, WorkDetailDTO.ID, ids);
			createEqualFilter(filters, WorkDetailDTO.PROJECTID, projectIds);
			createEqualFilter(filters, WorkDetailDTO.ELEMENTTYPEID, elementTypeIds);
			createEqualFilter(filters, WorkDetailDTO.WORKNATURE, workNatures);
			createEqualFilter(filters, WorkDetailDTO.WORKDESC, workDescs);

			if (CollectionUtils.isNotEmpty(filters)) {
				searchObject.setFilters(filters);
			}
		}

		searchObject.setPageIndex(workDetailServiceRequest.getPageIndex());
		searchObject.setRecordstoFetch(workDetailServiceRequest.getRecordstoFetch());
		workDetails = workDetailRepo.search(searchObject);

		List<WorkDetailDTO> workDetailDTOs = new ArrayList<>();
		for (WorkDetail target : workDetails) {
			WorkDetailDTO workDetailDTO = conversionService.convert(target, WorkDetailDTO.class);
			workDetailDTOs.add(workDetailDTO);
		}
		WorkDetailServiceResponse workDetailServiceResponse = new WorkDetailServiceResponse();
		workDetailServiceResponse.setWorkDetailDTOs(workDetailDTOs);
		return workDetailServiceResponse;
	}

	@Override
	public WorkDetailServiceResponse updateWorkDetail(WorkDetailServiceRequest workDetailServiceRequest) {
		WorkDetailDTO source = workDetailServiceRequest.getWorkDetailDTO();

		WorkDetail target = workDetailRepo.findById(source.getId()).get();
		target.setWorkNature(source.getWorkNature());
		target.setWorkDesc(source.getWorkDesc());
		if (!target.getProjectId().equals(source.getProjectId())) {
			Project project = projectRepo.findById(source.getProjectId()).get();
			target.setProject(project);
		}
		if (!target.getElementTypeId().equals(source.getElementTypeId())) {
			ElementType elementType = elementTypeRepo.findById(source.getElementTypeId()).get();
			target.setElementType(elementType);
		}

		workDetailRepo.save(target);
		return new WorkDetailServiceResponse();
	}

	@Override
	public WorkDetailServiceResponse deleteWorkDetail(WorkDetailServiceRequest workDetailServiceRequest) {
		WorkDetailDTO workDetailDTO = workDetailServiceRequest.getWorkDetailDTO();
		workDetailRepo.deleteById(workDetailDTO.getId());
		return new WorkDetailServiceResponse();
	}
}