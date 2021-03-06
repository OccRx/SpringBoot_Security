package org.my.example.security.service;

import org.my.example.security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> findAll();

    User findUserById(long id);

    void save(User user);

    void updateUser(User newUser);

    void deleteUserById(long id);

    User findUserByNameAndRoles(String name);

}
