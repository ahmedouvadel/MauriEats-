package com.example.maurieats.Services.Iservice;

import com.example.maurieats.Dto.AdministratorDTO;

import java.util.List;

public interface IAdministrator {
    List<AdministratorDTO> getAllAdministrators();
    AdministratorDTO getAdministratorById(Long id);
    AdministratorDTO createAdministrator(AdministratorDTO administratorDTO);
    void deleteAdministrator(Long id);
}
