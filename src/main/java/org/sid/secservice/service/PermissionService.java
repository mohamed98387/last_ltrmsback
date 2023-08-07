package org.sid.secservice.service;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.Permission;

import java.util.List;

public interface PermissionService {
    Permission addNewPermission(Permission permission);
    List<Permission> listPermissions();
    public Permission updatePermission(Permission permission);
    public void removePermission(Long id);
}
