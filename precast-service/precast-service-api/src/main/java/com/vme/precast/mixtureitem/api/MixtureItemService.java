package com.vme.precast.mixtureitem.api;

public interface MixtureItemService {

	public MixtureItemServiceResponse createMixtureItem(MixtureItemServiceRequest serviceRequest);

	public MixtureItemServiceResponse getMixtureItems(MixtureItemServiceRequest serviceRequest);

	public MixtureItemServiceResponse updateMixtureItem(MixtureItemServiceRequest serviceRequest);

	public MixtureItemServiceResponse deleteMixtureItem(MixtureItemServiceRequest serviceRequest);
}
