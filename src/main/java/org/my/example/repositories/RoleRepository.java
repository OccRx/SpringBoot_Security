package org.my.example.repositories;

import org.my.example.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRoleName(String roleName);

    List<Role> findAll();

}
