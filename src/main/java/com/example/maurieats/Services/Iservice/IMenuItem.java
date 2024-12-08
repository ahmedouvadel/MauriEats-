package com.example.maurieats.Services.Iservice;

import com.example.maurieats.Dto.MenuItemDTO;

import java.util.List;

public interface IMenuItem {
    List<MenuItemDTO> getAllMenuItems();
    MenuItemDTO getMenuItemById(Long id);
    MenuItemDTO createMenuItem(MenuItemDTO menuItemDTO);
    void deleteMenuItem(Long id);
}
