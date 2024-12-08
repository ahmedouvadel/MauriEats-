package com.example.maurieats.DAO.Repository;


import com.example.maurieats.DAO.Entity.Order;
import com.example.maurieats.DAO.Enum.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByClientId(Long clientId); // Retrieve orders by client
    List<Order> findByVendorPageId(Long vendorPageId); // Retrieve orders for a specific vendor page
    List<Order> findByStatus(OrderStatus status); // Retrieve orders by status
}
