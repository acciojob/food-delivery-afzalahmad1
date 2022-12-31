package com.driver.converter;

import com.driver.io.entity.OrderEntity;
import com.driver.model.response.OrderDetailsResponse;
import com.driver.shared.dto.OrderDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OrderConverter {
    public static OrderEntity convertDtoToEntity(OrderDto orderDetailsRequestModel){
        return OrderEntity.builder()
                .items(orderDetailsRequestModel.getItems())
                .userId(orderDetailsRequestModel.getUserId())
                .cost(orderDetailsRequestModel.getCost())
                .build();
    }
    public static OrderDto convertEntityToDto(OrderEntity orderEntity){
        return OrderDto.builder()
                .orderId(orderEntity.getOrderId())
                .cost(orderEntity.getCost())
                .status(orderEntity.isStatus())
                .userId(orderEntity.getUserId())
                .build();
    }
}
