package com.vme.precast.costcentre.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.costcentre.api.CostCentreComponent;
import com.vme.precast.costcentre.api.CostCentreDTO;
import com.vme.precast.costcentre.api.CostCentreSearchDTO;
import com.vme.precast.costcentre.api.CostCentreServiceRequest;
import com.vme.precast.costcentre.api.CostCentreServiceResponse;
import com.vme.precast.domain.CostCentre;
import com.vme.precast.repository.CostCentreRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class CostCentreComponentImpl implements CostCentreComponent {
    @Autowired
    CostCentreRepo costCentreRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public CostCentreServiceResponse createCostCentre(CostCentreServiceRequest costCentreServiceRequest) {
        CostCentreDTO costCentreDTO = costCentreServiceRequest.getCostCentreDTO();
        CostCentre costcentre = (CostCentre) conversionUtility.convert(costCentreDTO, CostCentreDTO.class,
                CostCentre.class);
        costCentreRepo.save(costcentre);
        return null;
    }

    @Override
    public CostCentreServiceResponse getCostCentres(CostCentreServiceRequest costCentreServiceRequest) {
        List<CostCentre> costCentreList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        CostCentreSearchDTO costCentreSearchDTO = costCentreServiceRequest.getCostCentreSearchDTO();
        if (costCentreSearchDTO != null) {
            List<Long> idList = costCentreSearchDTO.getIdList();
            List<String> nameList = costCentreSearchDTO.getNameList();

            FilterUtils.createEqualFilter(filters, CostCentreSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, CostCentreSearchDTO.NAME, nameList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(costCentreServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(costCentreServiceRequest.getRecordstoFetch());
        costCentreList = costCentreRepo.search(searchObject);

        List<CostCentreDTO> costCentreDTOList = new ArrayList<>();
        for (CostCentre target : costCentreList) {
            costCentreDTOList
                    .add((CostCentreDTO) conversionUtility.convert(target, CostCentre.class, CostCentreDTO.class));
        }
        CostCentreServiceResponse costCentreServiceResponse = new CostCentreServiceResponse();
        costCentreServiceResponse.setCostCentreDTOList(costCentreDTOList);
        return costCentreServiceResponse;
    }

    @Override
    public CostCentreServiceResponse updateCostCentre(CostCentreServiceRequest costCentreServiceRequest) {
        CostCentreDTO source = costCentreServiceRequest.getCostCentreDTO();

        CostCentre target = costCentreRepo.findById(source.getId()).get();
        target.setName(source.getName());

        costCentreRepo.save(target);
        return null;
    }

    @Override
    public CostCentreServiceResponse deleteCostCentre(CostCentreServiceRequest costCentreServiceRequest) {
        CostCentreDTO costCentreDTO = costCentreServiceRequest.getCostCentreDTO();
        costCentreRepo.deleteById(costCentreDTO.getId());
        return null;
    }
}