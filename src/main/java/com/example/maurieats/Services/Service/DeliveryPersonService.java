package com.example.maurieats.Services.Service;


import com.example.maurieats.DAO.Entity.DeliveryPerson;
import com.example.maurieats.DAO.Enum.Role;
import com.example.maurieats.DAO.Repository.DeliveryPersonRepository;
import com.example.maurieats.Dto.DeliveryPersonDTO;
import com.example.maurieats.Mapper.DeliveryPersonMapper;
import com.example.maurieats.Services.Iservice.IDeliveryPerson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryPersonService implements IDeliveryPerson {
    private final DeliveryPersonRepository deliveryPersonRepository;

    private final DeliveryPersonMapper deliveryPersonMapper;

    @Override
    public List<DeliveryPersonDTO> getAllDeliveryPersons() {
        return deliveryPersonRepository.findAll()
                .stream()
                .map(deliveryPersonMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public DeliveryPersonDTO getDeliveryPersonById(Long id) {
        DeliveryPerson deliveryPerson = deliveryPersonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DeliveryPerson not found"));
        return deliveryPersonMapper.toDTO(deliveryPerson);
    }
    @Override
    public DeliveryPersonDTO createDeliveryPerson(DeliveryPersonDTO deliveryPersonDTO) {
        if (deliveryPersonDTO.getRole() != null && deliveryPersonDTO.getRole() != Role.DELIVERY_PERSON) {
            throw new IllegalArgumentException("Cannot assign a role other than DELIVERY_PERSON to a new client.");
        }
        DeliveryPerson deliveryPerson = deliveryPersonMapper.toEntity(deliveryPersonDTO);

        deliveryPerson.setRole(Role.DELIVERY_PERSON);

        DeliveryPerson savedDeliveryPerson = deliveryPersonRepository.save(deliveryPerson);
        return deliveryPersonMapper.toDTO(savedDeliveryPerson);
    }
    @Override
    public void deleteDeliveryPerson(Long id) {
        deliveryPersonRepository.deleteById(id);
    }
}
