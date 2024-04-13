package com.thanhtan.identityservice.Controller;

import com.thanhtan.identityservice.dto.request.ApiResponse;
import com.thanhtan.identityservice.dto.request.UserCreationRequest;
import com.thanhtan.identityservice.dto.request.UserUpdateRequest;
import com.thanhtan.identityservice.dto.response.UserResponse;
import com.thanhtan.identityservice.entity.User;
import com.thanhtan.identityservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;

    }

//    @GetMapping
//    ApiResponse<List<User>> getUsers(){
//        ApiResponse<User> apiResponse = new ApiResponse<>();
//        apiResponse.setCode(1000);
//        apiResponse.setResult(userService.getUsers());
//        return userService.getUsers();
//    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(userService.getUserRespone(userId));
        return apiResponse;
    }

    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(userService.updateUser(userId, request));
        return apiResponse;
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }

}
