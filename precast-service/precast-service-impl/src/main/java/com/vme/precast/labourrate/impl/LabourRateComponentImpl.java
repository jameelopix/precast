package com.vme.precast.labourrate.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.ElementType;
import com.vme.precast.domain.LabourRate;
import com.vme.precast.domain.Project;
import com.vme.precast.labourrate.api.LabourRateComponent;
import com.vme.precast.labourrate.api.LabourRateDTO;
import com.vme.precast.labourrate.api.LabourRateSearchDTO;
import com.vme.precast.labourrate.api.LabourRateServiceRequest;
import com.vme.precast.labourrate.api.LabourRateServiceResponse;
import com.vme.precast.repository.ElementTypeRepo;
import com.vme.precast.repository.LabourRateRepo;
import com.vme.precast.repository.ProjectRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class LabourRateComponentImpl implements LabourRateComponent {
    @Autowired
    LabourRateRepo labourRateRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    ElementTypeRepo elementTypeRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public LabourRateServiceResponse createLabourRate(LabourRateServiceRequest labourRateServiceRequest) {
        LabourRateDTO labourRateDTO = labourRateServiceRequest.getLabourRateDTO();
        LabourRate labourrate = (LabourRate) conversionUtility.convert(labourRateDTO, LabourRateDTO.class,
                LabourRate.class);
        labourRateRepo.save(labourrate);
        return null;
    }

    @Override
    public LabourRateServiceResponse getLabourRates(LabourRateServiceRequest labourRateServiceRequest) {
        List<LabourRate> labourRateList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        LabourRateSearchDTO labourRateSearchDTO = labourRateServiceRequest.getLabourRateSearchDTO();
        if (labourRateSearchDTO != null) {
            List<Long> idList = labourRateSearchDTO.getIdList();
            List<String> workTypeList = labourRateSearchDTO.getWorkTypeList();
            List<String> workDescList = labourRateSearchDTO.getWorkDescList();
            List<Double> rateList = labourRateSearchDTO.getRateList();
            List<String> unitList = labourRateSearchDTO.getUnitList();
            List<Long> projectIdList = labourRateSearchDTO.getProjectIdList();
            List<Long> elementTypeIdList = labourRateSearchDTO.getElementTypeIdList();

            FilterUtils.createEqualFilter(filters, LabourRateSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, LabourRateSearchDTO.WORKTYPE, workTypeList);
            FilterUtils.createEqualFilter(filters, LabourRateSearchDTO.WORKDESC, workDescList);
            FilterUtils.createEqualFilter(filters, LabourRateSearchDTO.RATE, rateList);
            FilterUtils.createEqualFilter(filters, LabourRateSearchDTO.UNIT, unitList);
            FilterUtils.createEqualFilter(filters, LabourRateSearchDTO.PROJECTID, projectIdList);
            FilterUtils.createEqualFilter(filters, LabourRateSearchDTO.ELEMENTTYPEID, elementTypeIdList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(labourRateServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(labourRateServiceRequest.getRecordstoFetch());
        labourRateList = labourRateRepo.search(searchObject);

        List<LabourRateDTO> labourRateDTOList = new ArrayList<>();
        for (LabourRate target : labourRateList) {
            labourRateDTOList
                    .add((LabourRateDTO) conversionUtility.convert(target, LabourRate.class, LabourRateDTO.class));
        }
        LabourRateServiceResponse labourRateServiceResponse = new LabourRateServiceResponse();
        labourRateServiceResponse.setLabourRateDTOList(labourRateDTOList);
        return labourRateServiceResponse;
    }

    @Override
    public LabourRateServiceResponse updateLabourRate(LabourRateServiceRequest labourRateServiceRequest) {
        LabourRateDTO source = labourRateServiceRequest.getLabourRateDTO();

        LabourRate target = labourRateRepo.findById(source.getId()).get();
        target.setWorkType(source.getWorkType());
        target.setWorkDesc(source.getWorkDesc());
        target.setRate(source.getRate());
        target.setUnit(source.getUnit());

        if (source.getElementTypeId() != null && !source.getElementTypeId().equals(target.getElementTypeId())) {
            ElementType elementType = elementTypeRepo.findById(source.getElementTypeId()).get();
            target.setElementType(elementType);
        }
        if (source.getProjectId() != null && !source.getProjectId().equals(target.getProjectId())) {
            Project project = projectRepo.findById(source.getProjectId()).get();
            target.setProject(project);
        }
        labourRateRepo.save(target);
        return null;
    }

    @Override
    public LabourRateServiceResponse deleteLabourRate(LabourRateServiceRequest labourRateServiceRequest) {
        LabourRateDTO labourRateDTO = labourRateServiceRequest.getLabourRateDTO();
        labourRateRepo.deleteById(labourRateDTO.getId());
        return null;
    }
}