package com.example.maurieats.Dto;

import com.example.maurieats.DAO.Enum.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private OrderStatus status;
    private Long clientId; // Reference to Client
    private Long vendorPageId; // Reference to VendorPage
    private Long deliveryPersonId; // Reference to DeliveryPerson
    private List<Long> menuItemIds; // List of MenuItem IDs
}
