package com.example.maurieats.Services.Service;

import com.example.maurieats.DAO.Entity.Order;
import com.example.maurieats.DAO.Repository.OrderRepository;
import com.example.maurieats.Dto.OrderDTO;
import com.example.maurieats.Mapper.OrderMapper;
import com.example.maurieats.Services.Iservice.IOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrder {
    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toDTO(order);
    }
    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDTO(savedOrder);
    }
    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
