package com.example.maurieats.Services.Iservice;

import com.example.maurieats.Dto.VendorPageDTO;

import java.util.List;

public interface IVendorPage {
    List<VendorPageDTO> getAllVendorPages();
    VendorPageDTO getVendorPageById(Long id);
    VendorPageDTO createVendorPage(VendorPageDTO vendorPageDTO);
    void deleteVendorPage(Long id);
}
