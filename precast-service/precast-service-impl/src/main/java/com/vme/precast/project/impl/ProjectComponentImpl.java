package com.vme.precast.project.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.domain.Project;
import com.vme.precast.project.api.ProjectComponent;
import com.vme.precast.project.api.ProjectDTO;
import com.vme.precast.project.api.ProjectSearchDTO;
import com.vme.precast.project.api.ProjectServiceRequest;
import com.vme.precast.project.api.ProjectServiceResponse;
import com.vme.precast.repository.ElementRepo;
import com.vme.precast.repository.ProjectRepo;
import com.vme.precast.shared.UnitType;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;

public class ProjectComponentImpl implements ProjectComponent {

	@Autowired
	ProjectRepo projectRepo;

	@Autowired
	ElementRepo elementRepo;

	@Autowired
	ConversionService conversionService;

	@Override
	public ProjectServiceResponse createProject(ProjectServiceRequest projectServiceRequest) {
		ProjectDTO projectDTO = projectServiceRequest.getProjectDTO();
		this.calculateAmount(projectDTO);
		Project project = conversionService.convert(projectDTO, Project.class);
		projectRepo.save(project);
		return new ProjectServiceResponse();
	}

	private void calculateAmount(ProjectDTO projectDTO) {
		if (projectDTO.getQuantity() != null) {
			if (projectDTO.getProductionRate() != null) {
				projectDTO.setProductionAmount(projectDTO.getQuantity() * projectDTO.getProductionRate());
			}
			if (projectDTO.getErectionRate() != null) {
				projectDTO.setErectionRate(projectDTO.getQuantity() * projectDTO.getErectionRate());
			}
			if (projectDTO.getLogisticsAmount() != null) {
				projectDTO.setLogisticsAmount(projectDTO.getQuantity() * projectDTO.getLogisticsAmount());
			}
		}
	}

	@Override
	public ProjectServiceResponse getProjects(ProjectServiceRequest projectServiceRequest) {
		List<Project> projects = new ArrayList<>();
		List<Filter> filters = new ArrayList<>();
		SearchObject searchObject = new SearchObject();

		ProjectSearchDTO searchDTO = projectServiceRequest.getProjectSearchDTO();
		if (searchDTO != null) {
			List<Long> ids = searchDTO.getIds();
			List<String> codes = searchDTO.getCodes();
			List<String> names = searchDTO.getNames();
			List<UnitType> unitTypes = searchDTO.getUnitTypes();
			List<Double> quantities = searchDTO.getQuantities();
			List<Double> productionRates = searchDTO.getProductionRates();
			List<Double> productionAmounts = searchDTO.getProductionAmounts();
			List<Double> logisticsRates = searchDTO.getLogisticsRates();
			List<Double> logisticsAmounts = searchDTO.getLogisticsAmounts();
			List<Double> erectionRates = searchDTO.getErectionRates();
			List<Double> erectionAmounts = searchDTO.getErectionAmounts();
			List<Double> miscAmounts = searchDTO.getMiscAmounts();
			List<Double> totalAmounts = searchDTO.getTotalAmounts();

			createEqualFilter(filters, ProjectDTO.ID, ids);
			createEqualFilter(filters, ProjectDTO.CODE, codes);
			createEqualFilter(filters, ProjectDTO.NAME, names);
			createEqualFilter(filters, ProjectDTO.UNITTYPE, unitTypes);
			createEqualFilter(filters, ProjectDTO.QUANTITY, quantities);
			createEqualFilter(filters, ProjectDTO.PRODUCTIONRATE, productionRates);
			createEqualFilter(filters, ProjectDTO.PRODUCTIONAMOUNT, productionAmounts);
			createEqualFilter(filters, ProjectDTO.LOGISTICSRATE, logisticsRates);
			createEqualFilter(filters, ProjectDTO.LOGISTICSAMOUNT, logisticsAmounts);
			createEqualFilter(filters, ProjectDTO.ERECTIONRATE, erectionRates);
			createEqualFilter(filters, ProjectDTO.ERECTIONAMOUNT, erectionAmounts);
			createEqualFilter(filters, ProjectDTO.MISCAMOUNT, miscAmounts);
			createEqualFilter(filters, ProjectDTO.TOTALAMOUNT, totalAmounts);

			if (CollectionUtils.isNotEmpty(filters)) {
				searchObject.setFilters(filters);
			}
		}

		searchObject.setPageIndex(projectServiceRequest.getPageIndex());
		searchObject.setRecordstoFetch(projectServiceRequest.getRecordstoFetch());
		projects = projectRepo.search(searchObject);

		List<ProjectDTO> projectDTOs = new ArrayList<>();
		for (Project target : projects) {
			ProjectDTO projectDTO = conversionService.convert(target, ProjectDTO.class);
			projectDTOs.add(projectDTO);
		}
		ProjectServiceResponse projectServiceResponse = new ProjectServiceResponse();
		projectServiceResponse.setProjectDTOs(projectDTOs);
		return projectServiceResponse;
	}

	@Override
	public ProjectServiceResponse updateProject(ProjectServiceRequest projectServiceRequest) {
		ProjectDTO source = projectServiceRequest.getProjectDTO();
		this.calculateAmount(source);

		Project target = projectRepo.findById(source.getId()).get();
		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setUnitType(source.getUnitType());
		target.setQuantity(source.getQuantity());
		target.setProductionRate(source.getProductionRate());
		target.setProductionAmount(source.getProductionAmount());
		target.setLogisticsRate(source.getLogisticsRate());
		target.setLogisticsAmount(source.getLogisticsAmount());
		target.setErectionRate(source.getErectionRate());
		target.setErectionAmount(source.getErectionAmount());
		target.setMiscAmount(source.getMiscAmount());
		target.setTotalAmount(source.getTotalAmount());

		projectRepo.save(target);
		return new ProjectServiceResponse();
	}

	@Override
	public ProjectServiceResponse deleteProject(ProjectServiceRequest projectServiceRequest) {
		ProjectDTO projectDTO = projectServiceRequest.getProjectDTO();
		projectRepo.deleteById(projectDTO.getId());
		return new ProjectServiceResponse();
	}

	@Override
	public ProjectServiceResponse estimateProject(ProjectServiceRequest projectServiceRequest) {
//		ProjectDTO projectDTO = projectServiceRequest.getProjectDTO();
//		Project project = projectRepo.findById(projectDTO.getId());
//		Iterable<Element> elements = elementRepo.findAll();
//
//		List<Element> filteredElements = new ArrayList<>();
//		for (Element element : elements) {
//			if (element.getProject().getId().equals(projectDTO.getId())) {
//				filteredElements.add(element);
//			}
//		}
//		double amount = 0;
//		for (Element element : filteredElements) {
//			double concreteQuantity = element.getBillingConcreteQuantity();
//			Mixture mixture = element.getMixture();
//			Set<MixtureItem> mixtureItems = mixture.getMixtureItems();
//			for (MixtureItem mixtureItem : mixtureItems) {
//				amount += (concreteQuantity * mixtureItem.getQuantity() * 100);
//			}
//		}
//		project.setEstimatedAmount(amount);
//		projectRepo.save(project);
		return null;
	}
}
