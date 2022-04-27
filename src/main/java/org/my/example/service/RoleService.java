package org.my.example.service;

import org.my.example.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void save(Role role);
}
