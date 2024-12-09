package com.example.maurieats.Services.Service;


import com.example.maurieats.DAO.Entity.Administrator;
import com.example.maurieats.DAO.Enum.Role;
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

    @Override
    public List<AdministratorDTO> getAllAdministrators() {
        return administratorRepository.findAll()
                .stream()
                .map(administratorMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public AdministratorDTO getAdministratorById(Long id) {
        Administrator administrator = administratorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrator not found"));
        return administratorMapper.toDTO(administrator);
    }
    @Override
    public AdministratorDTO createAdministrator(AdministratorDTO administratorDTO) {
        if (administratorDTO.getRole() != null && administratorDTO.getRole() != Role.ADMINISTRATOR) {
            throw new IllegalArgumentException("Cannot assign a role other than ADMINISTRATOR to a new client.");
        }
        Administrator administrator = administratorMapper.toEntity(administratorDTO);

        administrator.setRole(Role.ADMINISTRATOR);

        Administrator savedAdministrator = administratorRepository.save(administrator);
        return administratorMapper.toDTO(savedAdministrator);
    }
    @Override
    public void deleteAdministrator(Long id) {
        administratorRepository.deleteById(id);
    }
}