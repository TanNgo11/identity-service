package com.thanhtan.identityservice.mapper;

import com.thanhtan.identityservice.dto.request.PermissionRequest;
import com.thanhtan.identityservice.dto.response.PermissionResponse;
import com.thanhtan.identityservice.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
