package com.vme.precast.rawmaterial.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.RawMaterial;
import com.vme.precast.rawmaterial.api.RawMaterialComponent;
import com.vme.precast.rawmaterial.api.RawMaterialDTO;
import com.vme.precast.rawmaterial.api.RawMaterialSearchDTO;
import com.vme.precast.rawmaterial.api.RawMaterialServiceRequest;
import com.vme.precast.rawmaterial.api.RawMaterialServiceResponse;
import com.vme.precast.repository.RawMaterialRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class RawMaterialComponentImpl implements RawMaterialComponent {
    @Autowired
    RawMaterialRepo rawMaterialRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public RawMaterialServiceResponse createRawMaterial(RawMaterialServiceRequest rawMaterialServiceRequest) {
        RawMaterialDTO rawMaterialDTO = rawMaterialServiceRequest.getRawMaterialDTO();
        RawMaterial rawmaterial = (RawMaterial) conversionUtility.convert(rawMaterialDTO, RawMaterialDTO.class,
                RawMaterial.class);
        rawMaterialRepo.save(rawmaterial);
        return null;
    }

    @Override
    public RawMaterialServiceResponse getRawMaterials(RawMaterialServiceRequest rawMaterialServiceRequest) {
        List<RawMaterial> rawMaterialList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        RawMaterialSearchDTO rawMaterialSearchDTO = rawMaterialServiceRequest.getRawMaterialSearchDTO();
        if (rawMaterialSearchDTO != null) {
            List<Long> idList = rawMaterialSearchDTO.getIdList();
            List<String> nameList = rawMaterialSearchDTO.getNameList();
            List<String> typeList = rawMaterialSearchDTO.getTypeList();
            List<String> unitList = rawMaterialSearchDTO.getUnitList();

            FilterUtils.createEqualFilter(filters, RawMaterialSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, RawMaterialSearchDTO.NAME, nameList);
            FilterUtils.createEqualFilter(filters, RawMaterialSearchDTO.TYPE, typeList);
            FilterUtils.createEqualFilter(filters, RawMaterialSearchDTO.UNIT, unitList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(rawMaterialServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(rawMaterialServiceRequest.getRecordstoFetch());
        rawMaterialList = rawMaterialRepo.search(searchObject);

        List<RawMaterialDTO> rawMaterialDTOList = new ArrayList<>();
        for (RawMaterial target : rawMaterialList) {
            rawMaterialDTOList
                    .add((RawMaterialDTO) conversionUtility.convert(target, RawMaterial.class, RawMaterialDTO.class));
        }
        RawMaterialServiceResponse rawMaterialServiceResponse = new RawMaterialServiceResponse();
        rawMaterialServiceResponse.setRawMaterialDTOList(rawMaterialDTOList);
        return rawMaterialServiceResponse;
    }

    @Override
    public RawMaterialServiceResponse updateRawMaterial(RawMaterialServiceRequest rawMaterialServiceRequest) {
        RawMaterialDTO source = rawMaterialServiceRequest.getRawMaterialDTO();

        RawMaterial target = rawMaterialRepo.findById(source.getId()).get();
        target.setName(source.getName());

        rawMaterialRepo.save(target);
        return null;
    }

    @Override
    public RawMaterialServiceResponse deleteRawMaterial(RawMaterialServiceRequest rawMaterialServiceRequest) {
        RawMaterialDTO rawMaterialDTO = rawMaterialServiceRequest.getRawMaterialDTO();
        rawMaterialRepo.deleteById(rawMaterialDTO.getId());
        return null;
    }
}