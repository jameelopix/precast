package com.vme.precast.rawmaterial.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface RawMaterialService extends BaseService {

	@FlowDescriptor(flow = "createRawMaterial", request = "rawMaterialServiceRequest", response = "rawMaterialServiceResponse")
	public RawMaterialServiceResponse createRawMaterial(RawMaterialServiceRequest rawMaterialServiceRequest);

	@FlowDescriptor(flow = "getRawMaterials", request = "rawMaterialServiceRequest", response = "rawMaterialServiceResponse")
	public RawMaterialServiceResponse getRawMaterials(RawMaterialServiceRequest rawMaterialServiceRequest);

	@FlowDescriptor(flow = "updateRawMaterial", request = "rawMaterialServiceRequest", response = "rawMaterialServiceResponse")
	public RawMaterialServiceResponse updateRawMaterial(RawMaterialServiceRequest rawMaterialServiceRequest);

	@FlowDescriptor(flow = "deleteRawMaterial", request = "rawMaterialServiceRequest", response = "rawMaterialServiceResponse")
	public RawMaterialServiceResponse deleteRawMaterial(RawMaterialServiceRequest rawMaterialServiceRequest);
}
