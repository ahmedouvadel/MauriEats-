package com.example.maurieats.Services.Service;


import com.example.maurieats.DAO.Entity.Administrator;
import com.example.maurieats.DAO.Repository.AdministratorRepository;
import com.example.maurieats.Dto.AdministratorDTO;
import com.example.maurieats.Mapper.AdministratorMapper;
import com.example.maurieats.Services.Iservice.IAdministrator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdministratorService implements IAdministrator {


    private final AdministratorRepository administratorRepository;
    private final AdministratorMapper administratorMapper;

    public List<AdministratorDTO> getAllAdministrators() {
        return administratorRepository.findAll()
                .stream()
                .map(administratorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AdministratorDTO getAdministratorById(Long id) {
        Administrator administrator = administratorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrator not found"));
        return administratorMapper.toDTO(administrator);
    }

    public AdministratorDTO createAdministrator(AdministratorDTO administratorDTO) {
        Administrator administrator = administratorMapper.toEntity(administratorDTO);
        Administrator savedAdministrator = administratorRepository.save(administrator);
        return administratorMapper.toDTO(savedAdministrator);
    }

    public void deleteAdministrator(Long id) {
        administratorRepository.deleteById(id);
    }
}