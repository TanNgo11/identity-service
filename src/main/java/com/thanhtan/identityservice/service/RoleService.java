package com.thanhtan.identityservice.service;

import com.thanhtan.identityservice.dto.request.RoleRequest;
import com.thanhtan.identityservice.dto.response.RoleResponse;
import com.thanhtan.identityservice.entity.Role;
import com.thanhtan.identityservice.mapper.RoleMapper;
import com.thanhtan.identityservice.repository.PermissionRepository;
import com.thanhtan.identityservice.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleResponse createRole(RoleRequest request) {
        Role role = roleMapper.toRole(request);
        role.setPermissions(new HashSet<>(permissionRepository.findAllById(request.getPermissions())));
        return roleMapper.toRoleResponse(roleRepository.save(role));
    }

    public List<RoleResponse> getAllRoles() {
        return roleRepository
                .findAll()
                .stream()
                .map(roleMapper::toRoleResponse).collect(Collectors.toList());
    }

    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }





}
