package com.thanhtan.identityservice.service;

import com.thanhtan.identityservice.dto.request.UserCreationRequest;
import com.thanhtan.identityservice.dto.request.UserUpdateRequest;
import com.thanhtan.identityservice.dto.response.PaginatedApiResponse;
import com.thanhtan.identityservice.dto.response.UserResponse;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    UserResponse createUser(UserCreationRequest request);

    PaginatedApiResponse<UserResponse> getUsers(Pageable pageable);

    UserResponse updateUser(String userId, UserUpdateRequest request);
    void deleteUser(String userId);

}
