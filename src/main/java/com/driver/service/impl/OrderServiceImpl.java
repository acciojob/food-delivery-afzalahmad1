package com.driver.service.impl;

import com.driver.converter.FoodConverter;
import com.driver.converter.OrderConverter;
import com.driver.io.entity.FoodEntity;
import com.driver.io.entity.OrderEntity;
import com.driver.io.repository.OrderRepository;
import com.driver.service.OrderService;
import com.driver.shared.dto.FoodDto;
import com.driver.shared.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderDto createOrder(OrderDto order) {
        OrderEntity orderEntity = OrderConverter.convertDtoToEntity(order);
        orderEntity = orderRepository.save(orderEntity);

        OrderDto newOrder = OrderConverter.convertEntityToDto(orderEntity);
        return newOrder;
    }

    @Override
    public OrderDto getOrderById(String orderId) throws Exception {
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId);
        if(orderId == null){
            throw new Exception("orderId not found");
        }
        OrderDto orderDto = OrderConverter.convertEntityToDto(orderEntity);
        return orderDto;
    }

    @Override
    public OrderDto updateOrderDetails(String orderId, OrderDto order) throws Exception {
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId);
        if(orderEntity == null){
            throw new Exception("orderId not found");
        }
        orderEntity.setOrderId(order.getOrderId());
        orderEntity.setCost(order.getCost());
        orderEntity.setItems(order.getItems());
        orderEntity.setStatus(order.isStatus());

        OrderEntity newOrder = orderRepository.save(orderEntity);
        order = OrderConverter.convertEntityToDto(newOrder);
        return order;
    }

    @Override
    public void deleteOrder(String orderId) throws Exception {
    }

    @Override
    public List<OrderDto> getOrders() {
        ;
    }
}