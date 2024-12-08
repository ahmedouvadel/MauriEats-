package com.example.maurieats.DAO.Repository;

import com.example.maurieats.DAO.Entity.VendorPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorPageRepository extends JpaRepository<VendorPage, Long> {
    List<VendorPage> findByOwnerId(Long ownerId); // Retrieve vendor pages by owner (Client)
}
