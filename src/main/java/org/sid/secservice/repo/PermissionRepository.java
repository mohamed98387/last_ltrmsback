package org.sid.secservice.repo;

import org.sid.secservice.entities.AppUser;
import org.sid.secservice.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {
    Permission findPermissionById(Long id);
}
