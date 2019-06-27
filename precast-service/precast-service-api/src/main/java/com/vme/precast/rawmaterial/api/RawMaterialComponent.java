package com.vme.precast.rawmaterial.api;

import coliseum.service.ColiseumInterface;

public interface RawMaterialComponent extends ColiseumInterface {

 public RawMaterialServiceResponse createRawMaterial(RawMaterialServiceRequest rawMaterialServiceRequest);

 public RawMaterialServiceResponse getRawMaterials(RawMaterialServiceRequest rawMaterialServiceRequest);

 public RawMaterialServiceResponse updateRawMaterial(RawMaterialServiceRequest rawMaterialServiceRequest);

 public RawMaterialServiceResponse deleteRawMaterial(RawMaterialServiceRequest rawMaterialServiceRequest);
}
