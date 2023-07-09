package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleDao {
    List<Role> AllRoles();

    Role findRoleById(long id);

    Role findRoleByName(String name);

    void saveRole(Role role);
}
