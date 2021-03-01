package cinema.service;

import cinema.model.Role;
import cinema.model.User;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class InjectData {
    private final RoleService roleService;
    private final UserService userService;

    public InjectData(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void addRolesAndAdmin() {
        Role roleUser = new Role();
        roleUser.setRoleName(Role.RoleName.USER);
        roleService.add(roleUser);
        Role roleAdmin = new Role();
        roleAdmin.setRoleName(Role.RoleName.ADMIN);
        roleService.add(roleAdmin);

        User user = new User();
        user.setEmail("admin");
        user.setPassword("admin");
        user.setRoles(Set.of(roleAdmin));
        userService.add(user);
    }
}
