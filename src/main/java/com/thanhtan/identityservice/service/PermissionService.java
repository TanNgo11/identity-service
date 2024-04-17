package com.thanhtan.identityservice.service;

import com.thanhtan.identityservice.dto.request.PermissionRequest;
import com.thanhtan.identityservice.dto.response.PermissionResponse;
import com.thanhtan.identityservice.entity.Permission;
import com.thanhtan.identityservice.mapper.PermissionMapper;
import com.thanhtan.identityservice.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {

    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

   public PermissionResponse createPermission(PermissionRequest request){

        Permission permission = permissionMapper.toPermission(request);

        return permissionMapper.toPermissionResponse(permissionRepository.save(permission));
    }

    public List<PermissionResponse> getAllPermission() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).collect(Collectors.toList());
    }

    public  void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }

}
