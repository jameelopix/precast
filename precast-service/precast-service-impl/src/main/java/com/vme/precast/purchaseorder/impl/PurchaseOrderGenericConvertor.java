package com.vme.precast.purchaseorder.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.domain.PurchaseOrder;
import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;

@Component
public class PurchaseOrderGenericConvertor implements GenericConverter {

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(PurchaseOrder.class, PurchaseOrderDTO.class));
		convertiblePairs.add(new ConvertiblePair(PurchaseOrderDTO.class, PurchaseOrder.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (sourceType.getType() == PurchaseOrder.class && targetType.getType() == PurchaseOrderDTO.class) {
			target = this.convertToPurchaseOrderDTO((PurchaseOrder) source);
		}
		if (sourceType.getType() == PurchaseOrderDTO.class && targetType.getType() == PurchaseOrder.class) {
			target = this.convertToPurchaseOrder((PurchaseOrderDTO) source);
		}
		return target;
	}

	private Object convertToPurchaseOrder(PurchaseOrderDTO source) {
		PurchaseOrder target = new PurchaseOrder();
		target.setId(source.getId());
		target.setPurchaseOrderNo(source.getPurchaseOrderNo());
		target.setPurchaseDate(source.getPurchaseDate());
		if (CollectionUtils.isNotEmpty(source.getOrderItemDTOList())) {
			// TODO conversionutility needed
//			target.setOrderItems(source.getOrderItems());
		}

		target.setIssued(source.getIssued());
		target.setClosed(source.getClosed());
		return target;
	}

	private Object convertToPurchaseOrderDTO(PurchaseOrder source) {
		PurchaseOrderDTO target = new PurchaseOrderDTO();
		target.setId(source.getId());
		target.setPurchaseOrderNo(source.getPurchaseOrderNo());
		target.setPurchaseDate(source.getPurchaseDate());
		if (CollectionUtils.isNotEmpty(source.getOrderItems())) {
			// TODO conversionutility needed
//			target.setOrderItems(source.getOrderItems());			
		}
		target.setIssued(source.getIssued());
		target.setClosed(source.getClosed());
		return target;
	}
}