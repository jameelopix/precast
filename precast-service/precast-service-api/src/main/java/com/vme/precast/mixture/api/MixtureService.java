package com.vme.precast.mixture.api;

public interface MixtureService {

	public MixtureServiceResponse createMixture(MixtureServiceRequest serviceRequest);

	public MixtureServiceResponse getMixtures(MixtureServiceRequest serviceRequest);

	public MixtureServiceResponse updateMixture(MixtureServiceRequest serviceRequest);

	public MixtureServiceResponse deleteMixture(MixtureServiceRequest serviceRequest);
}
