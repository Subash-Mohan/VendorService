package com.marraigemate.vendorservice.service;

import com.marraigemate.vendorservice.DTO.VendorDTO;
import com.marraigemate.vendorservice.DTO.VendorUpdateRequest;

import java.util.List;

public interface VendorService {
    public String registerVendor(VendorDTO vendorDTO);
    public String updateVendor(List<VendorUpdateRequest> vendorUpdateRequestList, String vendorId);
    public VendorDTO getVendorById(String vendorId);
    public String deleteVendor(String vendorId);

}
