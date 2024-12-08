package com.example.maurieats.Mapper;

import com.example.maurieats.DAO.Entity.MenuItem;
import com.example.maurieats.Dto.MenuItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {
    @Mapping(source = "vendorPage.id", target = "vendorPageId")
    MenuItemDTO toDTO(MenuItem menuItem);

    @Mapping(source = "vendorPageId", target = "vendorPage.id")
    MenuItem toEntity(MenuItemDTO menuItemDTO);
}
