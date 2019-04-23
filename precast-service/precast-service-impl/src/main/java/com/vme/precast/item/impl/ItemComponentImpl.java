package com.vme.precast.item.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import com.vme.precast.domain.Item;
import com.vme.precast.item.api.ItemComponent;
import com.vme.precast.item.api.ItemDTO;
import com.vme.precast.item.api.ItemSearchDTO;
import com.vme.precast.item.api.ItemServiceRequest;
import com.vme.precast.item.api.ItemServiceResponse;
import com.vme.precast.repository.ItemRepo;
import com.vme.precast.shared.UnitType;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.FilterUtils;

@Component
public class ItemComponentImpl implements ItemComponent {
	@Autowired
	ItemRepo itemRepo;

	@Autowired
	ConversionService conversionService;

	@Override
	public ItemServiceResponse createItem(ItemServiceRequest itemServiceRequest) {
		ItemDTO itemDTO = itemServiceRequest.getItemDTO();
		Item item = conversionService.convert(itemDTO, Item.class);
		itemRepo.save(item);
		return null;
	}

	@Override
	public ItemServiceResponse getItems(ItemServiceRequest itemServiceRequest) {
		List<Item> itemList = new ArrayList<>();
		List<Filter> filters = new ArrayList<>();
		SearchObject searchObject = new SearchObject();

		ItemSearchDTO itemSearchDTO = itemServiceRequest.getItemSearchDTO();
		if (itemSearchDTO != null) {
			List<Long> ids = itemSearchDTO.getIds();
			List<String> nameList = itemSearchDTO.getNames();
			List<String> categoryList = itemSearchDTO.getCategorys();
			List<UnitType> unitTypeList = itemSearchDTO.getUnitTypeList();

			FilterUtils.createEqualFilter(filters, ItemSearchDTO.ID, ids);
			FilterUtils.createEqualFilter(filters, ItemSearchDTO.NAME, nameList);
			FilterUtils.createEqualFilter(filters, ItemSearchDTO.CATEGORY, categoryList);
			FilterUtils.createEqualFilter(filters, ItemSearchDTO.UNIT_TYPE, unitTypeList);

			if (CollectionUtils.isNotEmpty(filters)) {
				searchObject.setFilters(filters);
			}
		}
		searchObject.setPageIndex(itemServiceRequest.getPageIndex());
		searchObject.setRecordstoFetch(itemServiceRequest.getRecordstoFetch());
		itemList = itemRepo.search(searchObject);

		List<ItemDTO> itemDTOList = new ArrayList<>();
		for (Item target : itemList) {
			itemDTOList.add(conversionService.convert(target, ItemDTO.class));
		}
		ItemServiceResponse itemServiceResponse = new ItemServiceResponse();
		itemServiceResponse.setItemDTOList(itemDTOList);
		return itemServiceResponse;
	}

	@Override
	public ItemServiceResponse updateItem(ItemServiceRequest itemServiceRequest) {
		ItemDTO source = itemServiceRequest.getItemDTO();

		Item target = itemRepo.findById(source.getId()).get();
		target.setName(source.getName());
		target.setCategory(source.getCategory());
		target.setUnitType(source.getUnitType());

		itemRepo.save(target);
		return null;
	}

	@Override
	public ItemServiceResponse deleteItem(ItemServiceRequest itemServiceRequest) {
		ItemDTO itemDTO = itemServiceRequest.getItemDTO();
		itemRepo.deleteById(itemDTO.getId());
		return null;
	}
}
