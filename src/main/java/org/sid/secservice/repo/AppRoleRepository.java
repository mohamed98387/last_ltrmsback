package org.sid.secservice.repo;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.AppUser;
import org.sid.secservice.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
    AppRole findAppRoleById(Long id);
}
