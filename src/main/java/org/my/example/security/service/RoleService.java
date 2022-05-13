package org.my.example.security.service;

import org.my.example.security.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    Role findByRoleName(String roleName);
}
