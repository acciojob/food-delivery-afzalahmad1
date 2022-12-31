package com.driver.converter;

import com.driver.io.entity.FoodEntity;
import com.driver.model.response.FoodDetailsResponse;
import com.driver.shared.dto.FoodDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FoodConverter {
    public static FoodEntity convertDtoToEntity(FoodDto foodDetailsRequestModel){
        return FoodEntity.builder().
                foodName(foodDetailsRequestModel.getFoodName())
                .foodCategory(foodDetailsRequestModel.getFoodCategory())
                .foodPrice(foodDetailsRequestModel.getFoodPrice()).build();
    }
    public static FoodDto convertEntityToDto(FoodEntity foodEntity){
        return FoodDto.builder()
                .foodCategory(foodEntity.getFoodCategory())
                .foodId(foodEntity.getFoodId())
                .foodName(foodEntity.getFoodName())
                .foodPrice(foodEntity.getFoodPrice())
                .build();
    }
}
