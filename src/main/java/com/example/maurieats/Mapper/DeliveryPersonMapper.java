package com.example.maurieats.Mapper;

import com.example.maurieats.DAO.Entity.DeliveryPerson;
import com.example.maurieats.Dto.DeliveryPersonDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryPersonMapper {
    DeliveryPersonDTO toDTO(DeliveryPerson deliveryPerson);
    DeliveryPerson toEntity(DeliveryPersonDTO deliveryPersonDTO);
}