package com.example.maurieats.Mapper;

import com.example.maurieats.DAO.Entity.Order;
import com.example.maurieats.Dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "vendorPage.id", target = "vendorPageId")
    @Mapping(source = "deliveryPerson.id", target = "deliveryPersonId")
    @Mapping(source = "items", target = "menuItemIds", ignore = true) // Map separately
    OrderDTO toDTO(Order order);

    @Mapping(source = "clientId", target = "client.id")
    @Mapping(source = "vendorPageId", target = "vendorPage.id")
    @Mapping(source = "deliveryPersonId", target = "deliveryPerson.id")
    @Mapping(source = "menuItemIds", target = "items", ignore = true) // Map separately
    Order toEntity(OrderDTO orderDTO);
}
