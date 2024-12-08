package com.example.maurieats.Controller;

import com.example.maurieats.Dto.DeliveryPersonDTO;
import com.example.maurieats.Services.Iservice.IDeliveryPerson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery-persons")
@RequiredArgsConstructor
public class DeliveryPersonController {
    private final IDeliveryPerson deliveryPersonService;

    @GetMapping
    public ResponseEntity<List<DeliveryPersonDTO>> getAllDeliveryPersons() {
        return ResponseEntity.ok(deliveryPersonService.getAllDeliveryPersons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryPersonDTO> getDeliveryPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(deliveryPersonService.getDeliveryPersonById(id));
    }

    @PostMapping
    public ResponseEntity<DeliveryPersonDTO> createDeliveryPerson(@RequestBody DeliveryPersonDTO deliveryPersonDTO) {
        return ResponseEntity.ok(deliveryPersonService.createDeliveryPerson(deliveryPersonDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliveryPerson(@PathVariable Long id) {
        deliveryPersonService.deleteDeliveryPerson(id);
        return ResponseEntity.noContent().build();
    }
}