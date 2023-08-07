package org.sid.secservice.web;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.Permission;
import org.sid.secservice.repo.PermissionRepository;
import org.sid.secservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PermissionRestController {
    private PermissionService permissionService;
    private PermissionRepository permissionRepository;

    public PermissionRestController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }
    public PermissionRestController(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }
@Autowired
    public PermissionRestController(PermissionService permissionService, PermissionRepository permissionRepository) {
        this.permissionService = permissionService;
        this.permissionRepository = permissionRepository;
    }
    @PostMapping(path = "/addpermission")
    public Permission savePermission(@RequestBody Permission permission) {
        return permissionService.addNewPermission(permission);
    }
    @GetMapping(path = "/permissions")
    public List<Permission> Permissions() {
        return permissionService.listPermissions();
    }
    @PutMapping("/update-permission")
    public Permission updatePermission(@RequestBody Permission permission) {
        Permission permissionsaved= permissionService.updatePermission(permission);
        return permissionsaved;
    }
    @DeleteMapping("/remove-permission/{permission-id}")
    public void removePermission(@PathVariable("permission-id") Long id) {
        permissionService.removePermission(id);
    }

}
