package org.my.example.security.util;

import org.my.example.security.model.Role;
import org.my.example.security.model.User;
import org.my.example.security.service.RoleService;
import org.my.example.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdminInit {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminInit(UserService userService, RoleService rolesService) {
        this.userService = userService;
        this.roleService = rolesService;
    }

    @PostConstruct
    public void init()  {
        if (roleService.findByRoleName("ROLE_ADMIN") == null) {
            Role role = new Role("ROLE_ADMIN");
            Role role1 = new Role("ROLE_USER");
            roleService.save(role);
            roleService.save(role1);
            List<Role> roleAdminUser = new ArrayList<>();
            roleAdminUser.add(role);
            roleAdminUser.add(role1);
            List<Role> roleUser = new ArrayList<>();
            roleUser.add(role1);
            User admin = new User("admin", 54, "admin", "123", roleAdminUser);
            User user1 = new User("user", 54, "neadmin", "123", roleUser);
            User user2 = new User("user1", 54, "neadmin", "123", roleUser);
            userService.save(admin);
            userService.save(user1);
            userService.save(user2);
        }
    }
}
