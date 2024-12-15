package com.example.maurieats.DAO.Repository;


import com.example.maurieats.DAO.Entity.OrderClient;
import com.example.maurieats.DAO.Enum.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderClient, Long> {
    List<OrderClient> findByClientId(Long clientId); // Retrieve orders by client
    List<OrderClient> findByVendorPageId(Long vendorPageId); // Retrieve orders for a specific vendor page
    List<OrderClient> findByStatus(OrderStatus status); // Retrieve orders by status
}
