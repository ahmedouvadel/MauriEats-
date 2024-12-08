package com.example.maurieats.Services.Iservice;

import com.example.maurieats.Dto.SubAdministratorDTO;

import java.util.List;

public interface ISubAdministrator {
    List<SubAdministratorDTO> getAllSubAdministrators();
    SubAdministratorDTO getSubAdministratorById(Long id);
    SubAdministratorDTO createSubAdministrator(SubAdministratorDTO subAdministratorDTO);
    void deleteSubAdministrator(Long id);
}
