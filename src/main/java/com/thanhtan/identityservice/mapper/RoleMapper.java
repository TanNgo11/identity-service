package com.thanhtan.identityservice.mapper;

import com.thanhtan.identityservice.dto.request.RoleRequest;
import com.thanhtan.identityservice.dto.response.RoleResponse;
import com.thanhtan.identityservice.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
