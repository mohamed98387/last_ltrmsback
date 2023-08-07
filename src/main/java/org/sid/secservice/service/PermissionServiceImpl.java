package org.sid.secservice.service;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.Permission;
import org.sid.secservice.repo.AppRoleRepository;
import org.sid.secservice.repo.PermissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    private PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Permission addNewPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> listPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission updatePermission(Permission permission) {
        return (Permission) permissionRepository.save(permission);
    }

    @Override
    public void removePermission(Long id) {
        permissionRepository.deleteById(id);
    }


}
