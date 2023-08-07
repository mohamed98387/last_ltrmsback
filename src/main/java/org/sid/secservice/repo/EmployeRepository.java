package org.sid.secservice.repo;

import org.sid.secservice.entities.Employe;
import org.sid.secservice.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
