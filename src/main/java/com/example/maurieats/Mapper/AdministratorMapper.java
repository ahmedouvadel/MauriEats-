package com.example.maurieats.Mapper;

import com.example.maurieats.DAO.Entity.Administrator;
import com.example.maurieats.Dto.AdministratorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdministratorMapper {
    AdministratorDTO toDTO(Administrator administrator);
    Administrator toEntity(AdministratorDTO administratorDTO);
}
