package com.vme.precast.rawmaterial.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface RawMaterialService extends BaseService {

 @FlowDescriptor(flow = "createrawmaterial", request = "rawMaterialServiceRequest", response = "rawMaterialServiceResponse")
 public RawMaterialServiceResponse createRawMaterial(RawMaterialServiceRequest rawMaterialServiceRequest);

 @FlowDescriptor(flow = "getrawmaterials", request = "rawMaterialServiceRequest", response = "rawMaterialServiceResponse")
 public RawMaterialServiceResponse getRawMaterials(RawMaterialServiceRequest rawMaterialServiceRequest);

 @FlowDescriptor(flow = "updaterawmaterial", request = "rawMaterialServiceRequest", response = "rawMaterialServiceResponse")
 public RawMaterialServiceResponse updateRawMaterial(RawMaterialServiceRequest rawMaterialServiceRequest);

 @FlowDescriptor(flow = "deleterawmaterial", request = "rawMaterialServiceRequest", response = "rawMaterialServiceResponse")
 public RawMaterialServiceResponse deleteRawMaterial(RawMaterialServiceRequest rawMaterialServiceRequest);
}