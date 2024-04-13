package com.thanhtan.identityservice.mapper;


import com.thanhtan.identityservice.dto.request.UserCreationRequest;
import com.thanhtan.identityservice.dto.request.UserUpdateRequest;
import com.thanhtan.identityservice.dto.response.UserResponse;
import com.thanhtan.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
