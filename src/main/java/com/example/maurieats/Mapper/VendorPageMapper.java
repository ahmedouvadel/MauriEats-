package com.example.maurieats.Mapper;

import com.example.maurieats.DAO.Entity.VendorPage;
import com.example.maurieats.Dto.VendorPageDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VendorPageMapper {
    VendorPageDTO toDTO(VendorPage vendorPage);
    VendorPage toEntity(VendorPageDTO vendorPageDTO);
}
