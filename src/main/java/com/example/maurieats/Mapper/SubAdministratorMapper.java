package com.example.maurieats.Mapper;

import com.example.maurieats.DAO.Entity.SubAdministrator;
import com.example.maurieats.Dto.SubAdministratorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubAdministratorMapper {
    @Mapping(source = "administrator.id", target = "administratorId")
    SubAdministratorDTO toDTO(SubAdministrator subAdministrator);

    @Mapping(source = "administratorId", target = "administrator.id")
    SubAdministrator toEntity(SubAdministratorDTO subAdministratorDTO);
}
