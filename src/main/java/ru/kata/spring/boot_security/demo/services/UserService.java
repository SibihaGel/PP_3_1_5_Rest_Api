package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> AllUser();

    List<Role> AllRoles();

    User findUserById(long id);

    User findUserByEmail(String email);

    User findUserByName(String name);

    Role findRoleById(long id);

    Role findRoleByName(String name);

    void saveUser(User user);

    void deleteUser(long id);

    void saveRole(Role role);
}