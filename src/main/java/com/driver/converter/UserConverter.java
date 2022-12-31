package com.driver.converter;

import com.driver.io.entity.UserEntity;
import com.driver.model.request.UserDetailsRequestModel;
import com.driver.model.response.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {
    public static UserEntity convertDtoToEntity(UserDetailsRequestModel userDetailsRequestModel){
        return UserEntity.builder()
                .email(userDetailsRequestModel.getEmail())
                .firstName(userDetailsRequestModel.getFirstName())
                .lastName(userDetailsRequestModel.getLastName())
                .build();
    }
    public static UserResponse convertEntityToDto(UserEntity userEntity){
        return UserResponse.builder()
                .userId(userEntity.getUserId())
                .email(userEntity.getEmail())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .build();
    }
}
