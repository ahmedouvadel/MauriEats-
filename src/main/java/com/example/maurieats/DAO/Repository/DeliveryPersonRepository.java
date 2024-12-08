package com.example.maurieats.DAO.Repository;

import com.example.maurieats.DAO.Entity.DeliveryPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, Long> {
    List<DeliveryPerson> findByAvailability(Boolean availability); // Retrieve available delivery persons
}