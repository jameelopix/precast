package com.vme.precast.labourworkentry.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.ElementType;
import com.vme.precast.domain.LabourWorkEntry;
import com.vme.precast.domain.Project;
import com.vme.precast.domain.SubContractor;
import com.vme.precast.repository.ElementTypeRepo;
import com.vme.precast.repository.LabourWorkEntryRepo;
import com.vme.precast.repository.ProjectRepo;
import com.vme.precast.repository.SubContractorRepo;
import com.vme.precast.labourworkentry.api.LabourWorkEntryComponent;
import com.vme.precast.labourworkentry.api.LabourWorkEntryDTO;
import com.vme.precast.labourworkentry.api.LabourWorkEntrySearchDTO;
import com.vme.precast.labourworkentry.api.LabourWorkEntryServiceRequest;
import com.vme.precast.labourworkentry.api.LabourWorkEntryServiceResponse;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class LabourWorkEntryComponentImpl implements LabourWorkEntryComponent {
    @Autowired
    LabourWorkEntryRepo labourWorkEntryRepo;
    @Autowired
    ElementTypeRepo elementTypeRepo;
    @Autowired
    SubContractorRepo subContractorRepo;
    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public LabourWorkEntryServiceResponse createLabourWorkEntry(
            LabourWorkEntryServiceRequest labourWorkEntryServiceRequest) {
        LabourWorkEntryDTO labourWorkEntryDTO = labourWorkEntryServiceRequest.getLabourWorkEntryDTO();
        LabourWorkEntry labourworkentry = (LabourWorkEntry) conversionUtility.convert(labourWorkEntryDTO,
                LabourWorkEntryDTO.class, LabourWorkEntry.class);

        if (labourWorkEntryDTO.getSubContractorId() != null) {
            SubContractor subContractor = subContractorRepo.findById(labourWorkEntryDTO.getSubContractorId()).get();
            labourworkentry.setSubContractor(subContractor);
        }
        if (labourWorkEntryDTO.getProjectId() != null) {
            Project project = projectRepo.findById(labourWorkEntryDTO.getProjectId()).get();
            labourworkentry.setProject(project);
        }
        if (labourWorkEntryDTO.getElementTypeId() != null) {
            ElementType elementType = elementTypeRepo.findById(labourWorkEntryDTO.getElementTypeId()).get();
            labourworkentry.setElementType(elementType);
        }

        labourWorkEntryRepo.save(labourworkentry);
        return null;
    }

    @Override
    public LabourWorkEntryServiceResponse getLabourWorkEntrys(
            LabourWorkEntryServiceRequest labourWorkEntryServiceRequest) {
        List<LabourWorkEntry> labourWorkEntryList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        LabourWorkEntrySearchDTO labourWorkEntrySearchDTO = labourWorkEntryServiceRequest.getLabourWorkEntrySearchDTO();
        if (labourWorkEntrySearchDTO != null) {
            List<Long> idList = labourWorkEntrySearchDTO.getIdList();
            List<String> workTypeList = labourWorkEntrySearchDTO.getWorkTypeList();
            List<String> workDescList = labourWorkEntrySearchDTO.getWorkDescList();
            List<Double> quantityList = labourWorkEntrySearchDTO.getQuantityList();
            List<String> unitList = labourWorkEntrySearchDTO.getUnitList();
            List<Long> subContractorIdList = labourWorkEntrySearchDTO.getSubContractorIdList();
            List<Long> projectIdList = labourWorkEntrySearchDTO.getProjectIdList();
            List<Long> elementTypeIdList = labourWorkEntrySearchDTO.getElementTypeIdList();

            FilterUtils.createEqualFilter(filters, LabourWorkEntrySearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, LabourWorkEntrySearchDTO.WORKTYPE, workTypeList);
            FilterUtils.createEqualFilter(filters, LabourWorkEntrySearchDTO.WORKDESC, workDescList);
            FilterUtils.createEqualFilter(filters, LabourWorkEntrySearchDTO.QUANTITY, quantityList);
            FilterUtils.createEqualFilter(filters, LabourWorkEntrySearchDTO.UNIT, unitList);
            FilterUtils.createEqualFilter(filters, LabourWorkEntrySearchDTO.SUBCONTRACTORID, subContractorIdList);
            FilterUtils.createEqualFilter(filters, LabourWorkEntrySearchDTO.PROJECTID, projectIdList);
            FilterUtils.createEqualFilter(filters, LabourWorkEntrySearchDTO.ELEMENTTYPEID, elementTypeIdList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(labourWorkEntryServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(labourWorkEntryServiceRequest.getRecordstoFetch());
        labourWorkEntryList = labourWorkEntryRepo.search(searchObject);

        List<LabourWorkEntryDTO> labourWorkEntryDTOList = new ArrayList<>();
        for (LabourWorkEntry target : labourWorkEntryList) {
            labourWorkEntryDTOList.add((LabourWorkEntryDTO) conversionUtility.convert(target, LabourWorkEntry.class,
                    LabourWorkEntryDTO.class));
        }
        LabourWorkEntryServiceResponse labourWorkEntryServiceResponse = new LabourWorkEntryServiceResponse();
        labourWorkEntryServiceResponse.setLabourWorkEntryDTOList(labourWorkEntryDTOList);
        return labourWorkEntryServiceResponse;
    }

    @Override
    public LabourWorkEntryServiceResponse updateLabourWorkEntry(
            LabourWorkEntryServiceRequest labourWorkEntryServiceRequest) {
        LabourWorkEntryDTO source = labourWorkEntryServiceRequest.getLabourWorkEntryDTO();

        LabourWorkEntry target = labourWorkEntryRepo.findById(source.getId()).get();
        target.setWorkType(source.getWorkType());
        target.setWorkDesc(source.getWorkDesc());
        target.setQuantity(source.getQuantity());
        target.setUnit(source.getUnit());

        if (source.getElementTypeId() != null && !source.getElementTypeId().equals(target.getElementTypeId())) {
            ElementType elementType = elementTypeRepo.findById(source.getElementTypeId()).get();
            target.setElementType(elementType);
        }
        if (source.getSubContractorId() != null && !source.getSubContractorId().equals(target.getSubContractorId())) {
            SubContractor subContractor = subContractorRepo.findById(source.getSubContractorId()).get();
            target.setSubContractor(subContractor);
        }
        if (source.getProjectId() != null && !source.getProjectId().equals(target.getProjectId())) {
            Project project = projectRepo.findById(source.getProjectId()).get();
            target.setProject(project);
        }
        labourWorkEntryRepo.save(target);
        return null;
    }

    @Override
    public LabourWorkEntryServiceResponse deleteLabourWorkEntry(
            LabourWorkEntryServiceRequest labourWorkEntryServiceRequest) {
        LabourWorkEntryDTO labourWorkEntryDTO = labourWorkEntryServiceRequest.getLabourWorkEntryDTO();
        labourWorkEntryRepo.deleteById(labourWorkEntryDTO.getId());
        return null;
    }
}