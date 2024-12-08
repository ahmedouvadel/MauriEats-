package com.example.maurieats.DAO.Repository;

import com.example.maurieats.DAO.Entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByVendorPageId(Long vendorPageId); // Retrieve menu items for a specific vendor page
}
