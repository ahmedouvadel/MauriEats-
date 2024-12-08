package com.example.maurieats.DAO.Repository;

import com.example.maurieats.DAO.Entity.SubAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubAdministratorRepository extends JpaRepository<SubAdministrator, Long> {
    SubAdministrator findByEmail(String email); // For login or retrieval by email
    List<SubAdministrator> findByAdministratorId(Long administratorId); // Retrieve sub-administrators for a specific admin
}
