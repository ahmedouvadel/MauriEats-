package com.example.maurieats.Services.Iservice;

import com.example.maurieats.Dto.DeliveryPersonDTO;

import java.util.List;

public interface IDeliveryPerson {
    List<DeliveryPersonDTO> getAllDeliveryPersons();
    DeliveryPersonDTO getDeliveryPersonById(Long id);
    DeliveryPersonDTO createDeliveryPerson(DeliveryPersonDTO deliveryPersonDTO);
    void deleteDeliveryPerson(Long id);
}
