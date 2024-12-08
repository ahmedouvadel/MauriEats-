package com.example.maurieats.DAO.Repository;

import com.example.maurieats.DAO.Entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByEmail(String email); // For login or retrieval by email
}
