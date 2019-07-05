package com.vme.precast.mixtureitem.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.Mixture;
import com.vme.precast.domain.MixtureItem;
import com.vme.precast.mixtureitem.api.MixtureItemComponent;
import com.vme.precast.mixtureitem.api.MixtureItemDTO;
import com.vme.precast.mixtureitem.api.MixtureItemSearchDTO;
import com.vme.precast.mixtureitem.api.MixtureItemServiceRequest;
import com.vme.precast.mixtureitem.api.MixtureItemServiceResponse;
import com.vme.precast.repository.MixtureItemRepo;
import com.vme.precast.repository.MixtureRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class MixtureItemComponentImpl implements MixtureItemComponent {
    @Autowired
    MixtureItemRepo mixtureItemRepo;
    @Autowired
    MixtureRepo mixtureRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public MixtureItemServiceResponse createMixtureItem(MixtureItemServiceRequest mixtureItemServiceRequest) {
        MixtureItemDTO mixtureItemDTO = mixtureItemServiceRequest.getMixtureItemDTO();
        MixtureItem mixtureitem = (MixtureItem) conversionUtility.convert(mixtureItemDTO, MixtureItemDTO.class,
                MixtureItem.class);

        if (mixtureItemDTO.getMixtureDTOId() != null) {
            Mixture mixture = mixtureRepo.findById(mixtureItemDTO.getMixtureDTOId()).get();
            mixtureitem.setMixture(mixture);
        }
        mixtureItemRepo.save(mixtureitem);
        return null;
    }

    @Override
    public MixtureItemServiceResponse getMixtureItems(MixtureItemServiceRequest mixtureItemServiceRequest) {
        List<MixtureItem> mixtureItemList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        MixtureItemSearchDTO mixtureItemSearchDTO = mixtureItemServiceRequest.getMixtureItemSearchDTO();
        if (mixtureItemSearchDTO != null) {
            List<Long> idList = mixtureItemSearchDTO.getIdList();
            List<String> rawMaterialNameList = mixtureItemSearchDTO.getRawMaterialNameList();
            List<Double> quantityList = mixtureItemSearchDTO.getQuantityList();
            List<String> unitList = mixtureItemSearchDTO.getUnitList();
            List<Long> mixtureDTOIdList = mixtureItemSearchDTO.getMixtureDTOIdList();

            FilterUtils.createEqualFilter(filters, MixtureItemSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, MixtureItemSearchDTO.RAWMATERIALNAME, rawMaterialNameList);
            FilterUtils.createEqualFilter(filters, MixtureItemSearchDTO.QUANTITY, quantityList);
            FilterUtils.createEqualFilter(filters, MixtureItemSearchDTO.UNIT, unitList);
            FilterUtils.createEqualFilter(filters, MixtureItemSearchDTO.MIXTUREID, mixtureDTOIdList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(mixtureItemServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(mixtureItemServiceRequest.getRecordstoFetch());
        mixtureItemList = mixtureItemRepo.search(searchObject);

        List<MixtureItemDTO> mixtureItemDTOList = new ArrayList<>();
        for (MixtureItem target : mixtureItemList) {
            mixtureItemDTOList
                    .add((MixtureItemDTO) conversionUtility.convert(target, MixtureItem.class, MixtureItemDTO.class));
        }
        MixtureItemServiceResponse mixtureItemServiceResponse = new MixtureItemServiceResponse();
        mixtureItemServiceResponse.setMixtureItemDTOList(mixtureItemDTOList);
        return mixtureItemServiceResponse;
    }

    @Override
    public MixtureItemServiceResponse updateMixtureItem(MixtureItemServiceRequest mixtureItemServiceRequest) {
        MixtureItemDTO source = mixtureItemServiceRequest.getMixtureItemDTO();

        MixtureItem target = mixtureItemRepo.findById(source.getId()).get();
        target.setQuantity(source.getQuantity());
        target.setUnit(source.getUnit());
        target.setRawMaterialName(source.getRawMaterialName());

        if (source.getMixtureDTOId() != null && !source.getMixtureDTOId().equals(target.getMixtureId())) {
            Mixture mixture = mixtureRepo.findById(source.getMixtureDTOId()).get();
            target.setMixture(mixture);
        }
        mixtureItemRepo.save(target);
        return null;
    }

    @Override
    public MixtureItemServiceResponse deleteMixtureItem(MixtureItemServiceRequest mixtureItemServiceRequest) {
        MixtureItemDTO mixtureItemDTO = mixtureItemServiceRequest.getMixtureItemDTO();
        mixtureItemRepo.deleteById(mixtureItemDTO.getId());
        return null;
    }
}