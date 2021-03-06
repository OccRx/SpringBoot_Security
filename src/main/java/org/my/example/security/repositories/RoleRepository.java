package org.my.example.security.repositories;

import org.my.example.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRoleName(String roleName);
}
