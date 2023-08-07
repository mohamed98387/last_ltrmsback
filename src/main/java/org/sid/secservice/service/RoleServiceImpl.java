package org.sid.secservice.service;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.AppUser;
import org.sid.secservice.entities.Permission;
import org.sid.secservice.repo.AppRoleRepository;
import org.sid.secservice.repo.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private AppRoleRepository approleRepository;
    private PermissionRepository permissionRepository;

    public RoleServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }
@Autowired
    public RoleServiceImpl(AppRoleRepository approleRepository, PermissionRepository permissionRepository) {
        this.approleRepository = approleRepository;
        this.permissionRepository = permissionRepository;
    }

    public RoleServiceImpl(AppRoleRepository approleRepository) {
        this.approleRepository = approleRepository;
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return approleRepository.save(appRole);
    }

    @Override
    public List<AppRole> listRoles() {
        return approleRepository.findAll();
    }

    @Override
    public AppRole updateRole(AppRole approle) {
        return (AppRole) approleRepository.save(approle);
    }

    @Override
    public void removeRole(Long id) {
        approleRepository.deleteById(id);
    }
    @Override
    public void addPermissionToRole(Long permissionId, Long roleId) {
        System.out.println("permissionId:"+permissionId);
        System.out.println("roleId:"+roleId);
        Permission permission=permissionRepository.findPermissionById(permissionId);
        AppRole appRole=approleRepository.findAppRoleById(roleId);
        System.out.println(permission);
        System.out.println(appRole);
        appRole.getPermissions().add(permission);
    }
}
