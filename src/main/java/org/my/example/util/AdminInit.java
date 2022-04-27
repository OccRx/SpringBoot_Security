package org.my.example.util;

import org.my.example.model.Role;
import org.my.example.model.User;
import org.my.example.service.RoleService;
import org.my.example.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdminInit {

    private UserService userService;
    private RoleService rolesService;


    public AdminInit(UserService userService, RoleService rolesService) {
        this.userService = userService;
        this.rolesService = rolesService;
    }

    @PostConstruct
    public void init()  {
        try {
            Role role = new Role("ROLE_ADMIN");
            Role role1 = new Role("ROLE_USER");
            rolesService.save(role);
            rolesService.save(role1);
            List<Role> roles = new ArrayList<>();
            roles.add(role);
            roles.add(role1);
            User admin = new User("admin", 54, "admin", "123", roles);
            userService.save(admin);

        } catch (RuntimeException ignored) {}
    }
}
