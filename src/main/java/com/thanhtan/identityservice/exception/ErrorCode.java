package com.thanhtan.identityservice.exception;


import org.springframework.http.HttpStatus;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    INVALID_KEY(1001, "Uncategorized error"),
    USER_EXISTED(1002, "User existed"),
    USERNAME_INVALID(1003, "Username must be at least 8 characters"),
    INVALID_PASSWORD(1004, "Password must be at least 8 characters"),
    USER_NOT_EXISTED(1005, "User not existed"),
    UNAUTHENTICATED(1006, "Unauthenticated"),
    UNAUTHORIZED(1007, "You do not have permission"),
    INVALID_DOB(1008, "Your age must be at least 8")
    ;

    private  int code;
    private String message;


    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;

    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
