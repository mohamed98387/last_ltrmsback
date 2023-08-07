package org.sid.secservice.web;


import lombok.Data;
import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.AppUser;
import org.sid.secservice.repo.AppRoleRepository;
import org.sid.secservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleRestController {
    private RoleService roleService;
    private AppRoleRepository appRoleRepository;

    public RoleRestController(AppRoleRepository appRoleRepository) {
        this.appRoleRepository = appRoleRepository;
    }

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }
    @Autowired
    public RoleRestController(RoleService roleService, AppRoleRepository appRoleRepository) {
        this.roleService = roleService;
        this.appRoleRepository = appRoleRepository;
    }
    @PostMapping(path = "/addrole")
    public AppRole saveRole(@RequestBody AppRole appRole) {
        return roleService.addNewRole(appRole);
    }
    @GetMapping(path = "/roles")
    public List<AppRole> appRoles() {
        return roleService.listRoles();
    }
    @PutMapping("/update-role")
    public AppRole updateRole(@RequestBody AppRole appRole) {
        AppRole role= roleService.updateRole(appRole);
        return role;
    }
    @DeleteMapping("/remove-role/{role-id}")
    public void removeRole(@PathVariable("role-id") Long id) {
        roleService.removeRole(id);
    }
    @PostMapping(path = "/addPermissionToRole")
    public void addPermissionToRole(@RequestBody PermissionRoleForm permissionRoleForm) {
        System.out.println(permissionRoleForm.getIdPermission());
        System.out.println(permissionRoleForm.getIdRole());
        roleService.addPermissionToRole(permissionRoleForm.getIdPermission(), permissionRoleForm.getIdRole());
    }
}
@Data
class PermissionRoleForm{
    private Long idPermission;
    private Long idRole;
}
