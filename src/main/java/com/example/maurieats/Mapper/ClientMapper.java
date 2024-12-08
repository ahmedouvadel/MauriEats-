package com.example.maurieats.Mapper;

import com.example.maurieats.DAO.Entity.Client;
import com.example.maurieats.Dto.ClientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDTO(Client client);
    Client toEntity(ClientDTO clientDTO);
}