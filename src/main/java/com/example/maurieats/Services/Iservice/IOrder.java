package com.example.maurieats.Services.Iservice;

import com.example.maurieats.Dto.OrderDTO;

import java.util.List;

public interface IOrder {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long id);
    OrderDTO createOrder(OrderDTO orderDTO);
    void deleteOrder(Long id);
}
