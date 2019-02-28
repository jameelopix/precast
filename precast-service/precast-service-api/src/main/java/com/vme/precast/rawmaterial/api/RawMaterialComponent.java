package com.vme.precast.rawmaterial.api;

public interface RawMaterialComponent {

	public RawMaterialServiceResponse createRawMaterial(RawMaterialServiceRequest serviceRequest);

	public RawMaterialServiceResponse getRawMaterials(RawMaterialServiceRequest serviceRequest);

	public RawMaterialServiceResponse updateRawMaterial(RawMaterialServiceRequest serviceRequest);

	public RawMaterialServiceResponse deleteRawMaterial(RawMaterialServiceRequest serviceRequest);
}
