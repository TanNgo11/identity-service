package com.thanhtan.identityservice.exception;

import com.thanhtan.identityservice.dto.request.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiResponse> runtimeExceptionHandler(RuntimeException e) {
        ApiResponse apiResponse =new ApiResponse();
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        return  ResponseEntity.badRequest().body(apiResponse);
    }


    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> appExceptionHandler(AppException e) {
        ErrorCode errorCode = e.getErrorCode();
        ApiResponse apiResponse =new ApiResponse();
        apiResponse.setMessage(errorCode.getMessage());
        apiResponse.setCode(errorCode.getCode());
        return  ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> validationExceptionHandler(MethodArgumentNotValidException e) {
        String enumKey =   e.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.valueOf(enumKey);
        ApiResponse apiResponse =new ApiResponse();
        apiResponse.setMessage(errorCode.getMessage());
        apiResponse.setCode(errorCode.getCode());
        return  ResponseEntity.badRequest().body(apiResponse);
    }
}
