package org.sid.secservice.service;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.AppUser;

import java.util.List;

public interface RoleService {
    AppRole addNewRole(AppRole appRole);
    List<AppRole> listRoles();
    public AppRole updateRole(AppRole approle);
    public void removeRole(Long id);
    public void addPermissionToRole(Long permissionId, Long roleId);
}
