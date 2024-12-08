package com.example.maurieats.Services.Service;


import com.example.maurieats.DAO.Entity.DeliveryPerson;
import com.example.maurieats.DAO.Repository.DeliveryPersonRepository;
import com.example.maurieats.Dto.DeliveryPersonDTO;
import com.example.maurieats.Mapper.DeliveryPersonMapper;
import com.example.maurieats.Services.Iservice.IDeliverPerson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryPersonService implements IDeliverPerson {


    private final DeliveryPersonRepository deliveryPersonRepository;

    private final DeliveryPersonMapper deliveryPersonMapper;

    public List<DeliveryPersonDTO> getAllDeliveryPersons() {
        return deliveryPersonRepository.findAll()
                .stream()
                .map(deliveryPersonMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DeliveryPersonDTO getDeliveryPersonById(Long id) {
        DeliveryPerson deliveryPerson = deliveryPersonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DeliveryPerson not found"));
        return deliveryPersonMapper.toDTO(deliveryPerson);
    }

    public DeliveryPersonDTO createDeliveryPerson(DeliveryPersonDTO deliveryPersonDTO) {
        DeliveryPerson deliveryPerson = deliveryPersonMapper.toEntity(deliveryPersonDTO);
        DeliveryPerson savedDeliveryPerson = deliveryPersonRepository.save(deliveryPerson);
        return deliveryPersonMapper.toDTO(savedDeliveryPerson);
    }

    public void deleteDeliveryPerson(Long id) {
        deliveryPersonRepository.deleteById(id);
    }
}
