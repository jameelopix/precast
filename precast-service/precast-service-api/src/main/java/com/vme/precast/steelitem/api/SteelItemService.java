package com.vme.precast.steelitem.api;

public interface SteelItemService {

	public SteelItemServiceResponse createSteelItem(SteelItemServiceRequest serviceRequest);

	public SteelItemServiceResponse getSteelItems(SteelItemServiceRequest serviceRequest);

	public SteelItemServiceResponse updateSteelItem(SteelItemServiceRequest serviceRequest);

	public SteelItemServiceResponse deleteSteelItem(SteelItemServiceRequest serviceRequest);
}
